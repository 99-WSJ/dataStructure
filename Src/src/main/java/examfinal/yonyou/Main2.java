package examfinal.yonyou;

/**
 * @program: Src
 * @description:
 * 第小友需要采购一批货物，数量为k，一共有n家供应商可以选择，
 * 每家供应商可以提供0到max数量的货物。
 * 采购部门要求每次采购需要从三家供应商中选择，请计算有多少种供应商组合。
 * 说明:供应商的选择可以重复，若无法组合则返回0。
 * 输入描述
 * 输入一共有两行:第一行输入一个正整数n，一个正整数k，分别表示供应商数量和需采购货物数量
 * 第二行输入n个正整数gi，表示每个供应商可以提供的货物数量。
 * 输出描述
 * 输出供应商组合数量
 * @author: wsj
 * @create: 2024-09-06 18:46
 **/

import java.util.Scanner;

public class Main2 {


    static long count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        System.out.println(countCombinations(n, k, arr));
    }
    public static long countCombinations(int n, long k, long[] arr) {
        long count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int l = j; l < n; l++) {
                    if (arr[i] + arr[j] + arr[l] == k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public static void dfs(int[] arr, int n, int k, int start, int sum, int depth) {
        if (depth == 3) {
            if (sum == k) {
                count++;
            }
            return;
        }
        for (int i = start; i < n; i++) {
            if (sum + arr[i] > k) {
                continue;
            }
            dfs(arr, n, k, i + 1, sum + arr[i], depth + 1);
        }
    }
}

