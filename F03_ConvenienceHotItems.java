/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        int n = c.nextInt();
        c.nextLine(); // 清除換行符

        String[] names = new String[n];
        int[] qtys = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = c.next();
            qtys[i] = c.nextInt();
        }

        // 插入排序：根據 qtys 由大到小排序，對應調整 names
        for (int i = 1; i < n; i++) {
            int keyQty = qtys[i];
            String keyName = names[i];
            int j = i - 1;

            while (j >= 0 && qtys[j] < keyQty) {
                qtys[j + 1] = qtys[j];
                names[j + 1] = names[j];
                j--;
            }
            qtys[j + 1] = keyQty;
            names[j + 1] = keyName;
        }

        // 輸出前 10 名
        int limit = Math.min(10, n);
        for (int i = 0; i < limit; i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }
    }
}

/*
計算複雜度分析：

- 讀入 n 筆資料為 O(n)
- 插入排序最壞情況（完全反序）為 O(n^2)
- 輸出前 10 筆資料為 O(1)（固定最多 10 筆）

因此，整體時間複雜度為：O(n^2)
空間複雜度為：O(n)（儲存商品名稱與數量陣列）

由於 n 最大為 200，插入排序效能足以應付本題需求。
*/
