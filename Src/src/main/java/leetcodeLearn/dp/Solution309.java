package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 309、最佳买卖股票实际含冷冻期
 * 买卖多次，卖出有一天冷冻期
 * @author: wsj
 * @create: 2024-06-13 13:24
 **/
public class Solution309 {
    public static void main(String[] args) {
        int[] prices = {1,2,0,2};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
