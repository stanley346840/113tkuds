/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int diameter = 0;

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        // 輸入層序序列 -1 表 null
        String[] parts = c.nextLine().split(" ");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        TreeNode root = buildTree(arr);

        diameter = 0;
        height(root);

        System.out.println("Diameter: " + diameter);
    }

    // 後序遞迴，返回高度並更新直徑
    public static int height(TreeNode node) {
        if (node == null) return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        // 以此節點為橋樑，計算左右高度和即為該點通過的路徑長度（邊數）
        int pathLen = leftH + rightH;

        if (pathLen > diameter) diameter = pathLen;

        return Math.max(leftH, rightH) + 1;
    }

    // 層序建樹
    public static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                queue.add(curr.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

/*
計算複雜度分析：

- buildTree：O(n)，n 為節點數
- height 遞迴訪問每節點一次：O(n)
- 每節點計算左右高度並更新直徑為 O(1)

整體時間複雜度：O(n)
空間複雜度：O(h)（遞迴堆疊空間，h 為樹高）

h 最差為 n（單鏈），最好為 log n（平衡樹）。
*/
