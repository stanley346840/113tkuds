/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stanleychang
 */
import java.util.*;

public class F05_LCMRecursive {
    // 輾轉相減法計算 GCD（遞迴版）
    public static int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        else return gcd(a, b - a);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int g = gcd(a, b);
        int lcm = a * b / g;

        System.out.println("LCM: " + lcm);
    }
}

/*
計算複雜度分析：

- 輾轉相減法 GCD：
  在最壞情況下，兩數差距很小（如 gcd(n, n-1)），每次只減 1，最多遞迴 O(n) 次。
  ⇒ 時間複雜度：最壞 O(max(a, b))

- LCM 計算為一次乘法與除法：O(1)

整體時間複雜度：O(max(a, b))
空間複雜度：O(max(a, b))（因為遞迴深度與呼叫堆疊）

註：若使用「輾轉相除法」則時間複雜度可降為 O(log max(a, b))，效能更佳。
*/
