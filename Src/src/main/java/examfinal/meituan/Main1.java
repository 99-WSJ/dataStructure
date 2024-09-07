package examfinal.meituan;

/**
 * @program: Src
 * @description: 第一题
 * 小美有一个长度为 n 的数组，她每次操作会执行如下:
 * 选定一个ai;，把这个数加上一个任意x(x > 0)，花費代价为 ai + x。
 * 现在小美想要把整个数组变成全部奇数或者全部偶数的最小代价是多少?
 * @author: wsj
 * @create: 2024-09-06 18:46
 **/

import java.util.Scanner;



public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        long p = 0;
        long q = 0;
        for (int num : arr) {
            if ((num & 1) == 0) {
                p += num + 1;
            } else {
                q += num + 1;
            }
        }
        System.out.println(Math.min(p, q));

    }
}
