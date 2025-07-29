/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        // 讀取站數
        int n = c.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = c.next();
        }

        // 讀取起訖站
        String start = c.next();
        String end = c.next();

        // 尋找起訖站索引
        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIdx = i;
            }
            if (stops[i].equals(end)) {
                endIdx = i;
            }
        }

        // 判斷是否找到站點
        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(endIdx - startIdx) + 1);
        }
    }
}/*
計算複雜度分析：

- 讀取 n 筆資料為 O(n)
- 搜尋起訖站的迴圈也是 O(n)
- 其他操作（比較、加減）為 O(1)

因此，整體時間複雜度為：O(n)
空間複雜度為：O(n)（儲存停靠站陣列）

n 為列車停靠站數（最多 131），效能足夠處理所有情況。
*/

