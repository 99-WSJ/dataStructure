package examfinal.mihayou;

import java.util.Scanner;

/**
 * @program: Src
 * @description:
 * @author: wsj
 * @create: 2024-09-04 16:03
 **/

public class Main2 {
    static int n, m;
    static int[] extra;
    static int[][] get;
    static int[][] source;
    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        extra = new int[m];
        for (int i = 0; i < m; i++) {
            extra[i] = scanner.nextInt();
        }

        get = new int[n][3];
        source = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                get[i][j] = scanner.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                source[i][j] = scanner.nextInt() - 1;
            }
        }
        int[] count = new int[m];
        dfs(0, 0, count);
        System.out.println(res);

    }

     static void dfs(int index, int currentSum, int[] count) {
        if (index == n) {
            int sum = currentSum;
            for (int i = 0; i < m; i++) {
                if (count[i] >= 3) {
                    sum += extra[i];
                }
            }
            res = Math.max(res, sum);
            return;
        }
        for (int i = 0; i < 3; i++) {
            int[] newCount = count.clone();
            newCount[source[index][i]]++;
            dfs(index + 1, currentSum + get[index][i], newCount);
        }
    }
}
