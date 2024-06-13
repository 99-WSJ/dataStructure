package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 1035.不相交的线
 *
 * 和1143一摸一样，最长公共子序列的长度
 * @author: wsj
 * @create: 2024-06-13 16:20
 **/
public class Solution1035 {
    public static void main(String[] args) {
        int[] c1 = {1,4,2};
        int[] c2 = {1,2,4};
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        dp[0][0] = 0;
        for(int i = 1; i<=c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if(c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[c1.length][c2.length]);
    }
}
