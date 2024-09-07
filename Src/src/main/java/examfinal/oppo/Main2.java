package examfinal.oppo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Src
 * @description:
 * @author: wsj
 * @create: 2024-09-04 16:03
 **/


//public class Main2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            b[i] = scanner.nextInt();
//        }
//
//        Arrays.sort(a);
//        Arrays.sort(b);
//
//        int[] p = new int[n];
//        int last = -1;
//        int len = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (a[i] != last) {
//                len = i + 1;
//                p[i] = len;
//                last = a[i];
//            } else {
//                p[i] = len;
//            }
//        }
//
//        int res = -1;
//        int j = 0;
//
//        for (int i = 0; i < n; i++) {
//            while (j < n && b[j] < a[i]) {
//                j++;
//            }
//
//            if (j < n) {
//                int lengthA = p[i];
//                int lengthB = n - j;
//                res = Math.max(res, lengthA + lengthB);
//            }
//        }
//
//        System.out.println(res);
//    }
//}

import java.math.BigInteger;

public class Main2 {
     static final int MOD = 1000000007;

     static long factorial(int num) {
        long res = 1;
        for (int i = 2; i <= num; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }


     static long combination(int k, int n) {
        if (k > n) {
            return 0;
        }
        long numerator = factorial(n);
        long denominator = (factorial(k) * factorial(n - k)) % MOD;
        return (numerator * func(denominator, MOD)) % MOD;
    }

     static long func(long a, long m) {
        return power(a, m - 2, m);
    }

     static long power(long x, long y, long m) {
        long res = 1;
        x = x % m;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % m;
            }
            y = y >> 1;
            x = (x * x) % m;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2; // 示例值，可以根据需要更改

        long sum = 0;

        // 累加 C(k, n) 从 k = 1 到 k = n
        for (int k = 1; k <= n; k++) {
            sum = (sum + combination(k, n)) % MOD;
        }

        System.out.println("Sum of C(k, n) for k from 1 to n is: " + sum);
    }
}
