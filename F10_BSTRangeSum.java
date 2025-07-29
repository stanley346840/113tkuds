/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int sum = 0;

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        // 建 BST（層序輸入，-1 為 null）
        String[] parts = c.nextLine().split(" ");
        int[] nodes = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nodes[i] = Integer.parseInt(parts[i]);
        }
        TreeNode root = buildTree(nodes);

        int L = c.nextInt();
        int R = c.nextInt();

        rangeSum(root, L, R);
        System.out.println("Sum: " + sum);
    }

    // 遞迴剪枝中序遍歷
    public static void rangeSum(TreeNode node, int L, int R) {
        if (node == null) return;

        if (node.val > L) rangeSum(node.left, L, R);   // 左子樹可能有解
        if (node.val >= L && node.val <= R) sum += node.val;
        if (node.val < R) rangeSum(node.right, L, R);  // 右子樹可能有解
    }

    // 層序建樹（-1 表 null）
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

- 最壞情況：所有節點都落入區間或無法剪枝 ⇒ O(n)
- 最佳情況：大量節點能剪枝（如全大於 R 或全小於 L）⇒ 少於 O(n)

因此：
時間複雜度：O(n) 最壞，剪枝有效時優於 O(n)
空間複雜度：O(h)，h 為樹高，遞迴堆疊空間
    - 最壞情況（不平衡樹）：O(n)
    - 最佳情況（平衡 BST）：O(log n)
*/
