package examfinal.meituan;

/**
 * @program: Src
 * @description:  太难了
 * @author: wsj
 * @create: 2024-09-06 18:46
 **/

import java.util.*;

import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int q = scanner.nextInt();


        int[] a = new int[n + 1];
        long totalCards = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            totalCards += a[i];
        }


        printResult(a, totalCards, n);


        for (int i = 0; i < q; i++) {

            char op = scanner.next().charAt(0);
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();

            for (int j = l; j <= r; j++) {
                if (op == '+') {
                    a[j] += x;
                    totalCards += x;
                } else if (op == '-') {
                    a[j] -= x;
                    totalCards -= x;
                }
            }


            printResult(a, totalCards, n);
        }


    }


     static void printResult(int[] a, long totalCards, int n) {
        int maxCount = 0;

        for (int i = 1; i <= n; i++) {
            maxCount = Math.max(maxCount, a[i]);
        }
        if (maxCount > totalCards / 2) {
            System.out.println(maxCount);
        } else {
            System.out.println(-1);
        }
    }
}


