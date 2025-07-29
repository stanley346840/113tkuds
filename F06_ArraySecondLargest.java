/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        int n = c.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = c.nextInt();
        }

        int[] result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result[1]);
    }

    // 回傳 [最大值, 次大值]
    public static int[] findSecondMax(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{arr[left], Integer.MIN_VALUE}; // 單一元素時，次大設為最小值
        }

        int mid = (left + right) / 2;
        int[] leftPair = findSecondMax(arr, left, mid);
        int[] rightPair = findSecondMax(arr, mid + 1, right);

        int max, second;

        if (leftPair[0] > rightPair[0]) {
            max = leftPair[0];
            second = Math.max(rightPair[0], leftPair[1]);
        } else {
            max = rightPair[0];
            second = Math.max(leftPair[0], rightPair[1]);
        }

        return new int[]{max, second};
    }
}

/*
計算複雜度分析：

- 每次遞迴分左右半段，為典型分治法：
  - T(n) = 2T(n/2) + O(1) ⇒ T(n) = O(n)

- 每層遞迴只進行常數比較與合併 ⇒ O(1)
- 整體遞迴深度為 log n 層，每層共訪問所有元素一次 ⇒ 總共 O(n)

因此：
時間複雜度：O(n)
空間複雜度：O(log n)（遞迴堆疊空間，最多 log n 層）

此方法不使用全域變數，且效率良好。
*/
