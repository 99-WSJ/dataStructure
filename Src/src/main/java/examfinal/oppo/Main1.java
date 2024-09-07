package examfinal.oppo;

import java.util.Scanner;

/**
 * @program: Src
 * @description: 第一题
 * @author: wsj
 * @create: 2024-09-04 16:03
 **/


import java.util.Scanner;
import java.util.Arrays;

public class Main1 {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);

        long res = 0;
        for (int i = 0; i < n; i++) {
            long temp = a[i];
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (b[mid] >= temp) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res = (res % MOD + power(2, i) * (power(2, n - right) - 1)) % MOD;


        }
        System.out.println(res);
    }

    static long power(long x, long y) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % MOD;
            }
            y = y >> 1;
            x = (x * x) % MOD;
        }
        return res;
    }
}
