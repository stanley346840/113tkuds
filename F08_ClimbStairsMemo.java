/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F08_ClimbStairsMemo {
    static int[] memo = new int[41]; // n ≤ 40

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        int n = c.nextInt();

        int ways = climb(n);
        System.out.println("Ways: " + ways);
    }

    public static int climb(int n) {
        if (n == 0) return 1;     // 走完剛好是一種方法
        if (n < 0) return 0;      // 無效路徑
        if (memo[n] != 0) return memo[n];

        memo[n] = climb(n - 1) + climb(n - 2) + climb(n - 3);
        return memo[n];
    }
}

/*
計算複雜度分析：

- 每個 f(k)（k from 0~n）只計算一次，之後直接從 memo 陣列取出
- 每次計算時間為 O(1)，最多計算 n 次

因此：
時間複雜度：O(n)
空間複雜度：O(n)（memo 陣列）

由於 n ≤ 40，此解法效能充足且無需進一步優化。
*/
