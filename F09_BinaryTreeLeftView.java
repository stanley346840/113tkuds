/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取層序輸入
        String[] parts = sc.nextLine().split(" ");
        int[] nodes = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nodes[i] = Integer.parseInt(parts[i]);
        }

        TreeNode root = buildTree(nodes);
        printLeftView(root);
    }

    // 根據層序建樹
    public static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();
            // 加左子
            if (i < arr.length && arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                queue.add(curr.left);
            }
            i++;
            // 加右子
            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // 輸出每層最左節點
    public static void printLeftView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("LeftView: ");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    System.out.print(curr.val + " ");
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }

        System.out.println();
    }
}

/*
計算複雜度分析：

假設輸入 n 個節點：

- 建樹：每個節點加入 queue 並建立最多 1 次 ⇒ O(n)
- Left View 輸出：
    每層最多掃一遍所有節點（BFS）⇒ O(n)

總時間複雜度：O(n)
總空間複雜度：O(n)（queue 最多同時存一層節點數）

由於只走訪一次整棵樹，效能良好，適用於中小型樹（如 n ≤ 10⁴）。
*/
