/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F07_AnagramPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int[] freq = new int[26];  // a~z 字母出現次數

        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                freq[lower - 'a']++;
            }
        }

        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        if (oddCount <= 1) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}

/*
計算複雜度分析：

- 掃描輸入字串：O(n)，n 為字串長度
- 建立字母頻率表：最多 26 個小寫英文字母 → O(1)
- 最終檢查 odd count 次數：O(26) = O(1)

因此：
時間複雜度：O(n)
空間複雜度：O(1)（固定大小的陣列 freq[26]）

備註：
若改用 bitmask 優化，也可達 O(Σ) 時間與空間，
其中 Σ 為英文字母數，固定為常數 26，屬常數階處理。
 */
