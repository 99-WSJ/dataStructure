package leetcodeLearn.dp;

/**
 * @author wsj
 * @description 63 不同路径2（有障碍）
 * @date 2024年05月09日 10:12
 */
public class Solution63 {
    public static void main(String[] args) {

        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }
        System.out.println(dp[m-1][n-1]);

    }
}
