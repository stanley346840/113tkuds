/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        // 讀取時間數
        int n = c.nextInt();
        c.nextLine(); // 換行

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = c.nextLine().split(":");
            int hh = Integer.parseInt(parts[0]);
            int mm = Integer.parseInt(parts[1]);
            times[i] = hh * 60 + mm; // 時間轉分鐘
        }

        // 讀取查詢時間
        String[] queryParts = c.nextLine().split(":");
        int qh = Integer.parseInt(queryParts[0]);
        int qm = Integer.parseInt(queryParts[1]);
        int query = qh * 60 + qm;

        // 二分搜尋找第一個 > query 的時間
        int left = 0, right = n - 1;
        int ansIdx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > query) {
                ansIdx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 輸出結果
        if (ansIdx == -1) {
            System.out.println("No bike");
        } else {
            int t = times[ansIdx];
            int hh = t / 60;
            int mm = t % 60;
            System.out.printf("%02d:%02d\n", hh, mm);
        }
    }
}

/*
計算複雜度分析：

- 將 n 筆時間字串轉為分鐘值：O(n)
- 二分搜尋找出第一個大於查詢時間的值：O(log n)
- 輸出與轉換操作為 O(1)

因此，整體時間複雜度為：O(n + log n) ≈ O(n)
空間複雜度為：O(n)（儲存時間陣列）

此程式可高效處理數百筆回補時間資料，適用於即時查詢應用。
*/
