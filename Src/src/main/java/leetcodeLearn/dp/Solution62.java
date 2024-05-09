package leetcodeLearn.dp;

/**
 * @author wsj
 * @description 62 不同路径
 * @date 2024年05月09日 9:12
 */
public class Solution62 {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        // 二维数组，可以改一维数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[m-1][n-1]);
    }
}
