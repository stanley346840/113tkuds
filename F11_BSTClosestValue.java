/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        // 層序建樹（-1 表 null）
        String[] parts = c.nextLine().split(" ");
        int[] nodes = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nodes[i] = Integer.parseInt(parts[i]);
        }
        TreeNode root = buildTree(nodes);

        int T =c.nextInt();

        int closest = findClosestValue(root, T);
        System.out.println("Closest: " + closest);
    }

    public static int findClosestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode curr = root;

        while (curr != null) {
            int currDiff = Math.abs(curr.val - target);
            int closestDiff = Math.abs(closest - target);

            if (currDiff < closestDiff || (currDiff == closestDiff && curr.val < closest)) {
                closest = curr.val;
            }

            if (target < curr.val) {
                curr = curr.left;
            } else if (target > curr.val) {
                curr = curr.right;
            } else {
                // 找到等於 target 的節點
                break;
            }
        }

        return closest;
    }

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

- 每次迭代向下走樹一層，最多 h 層（h 為樹高）
- 更新最接近值為 O(1)

因此：
時間複雜度：O(h)
空間複雜度：O(1)（迭代搜尋無額外空間）

若 BST 平衡，h 約為 O(log n)；最差（鏈狀）為 O(n)。
*/
