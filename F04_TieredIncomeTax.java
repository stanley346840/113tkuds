/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        int n = c.nextInt();
        long[] incomes = new long[n];

        for (int i = 0; i < n; i++) {
            incomes[i] = c.nextLong();
        }

        // 2025 綜所稅級距（單身綜合所得）
        // 超過起點才課該級差額
        int[] brackets = {0, 560000, 1260000, 2520000, 4720000, Integer.MAX_VALUE};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};

        long totalTax = 0;

        for (int i = 0; i < n; i++) {
            long income = incomes[i];
            long tax = 0;

            for (int j = brackets.length - 2; j >= 0; j--) {
                if (income > brackets[j]) {
                    tax += Math.round((income - brackets[j]) * rates[j]);
                    income = brackets[j];
                }
            }

            System.out.println("Tax: $" + tax);
            totalTax += tax;
        }

        // 平均稅額
        long avgTax = Math.round((double) totalTax / n);
        System.out.println("Average: $" + avgTax);
    }
}

/*
計算複雜度分析：

- 讀取 n 筆收入：O(n)
- 每筆收入進行階梯稅率計算：
  每筆最多檢查 5 級稅率，因此為 O(1)
- 共 n 筆 ⇒ O(n) 次計算與加總
- 最後平均與輸出為 O(1)

整體時間複雜度：O(n)
整體空間複雜度：O(n)（儲存收入陣列）

因為稅率級距固定，屬常數次數級距查表，故每筆計算為 O(1)。
*/
