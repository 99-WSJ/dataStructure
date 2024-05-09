package leetcodeLearn.dp;

/**
 * @author wsj 96 不同的二叉搜索树
 * @description
 * @date 2024年05月09日 14:33
 */
public class Solution96 {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        System.out.println(dp[n]);
    }
}
