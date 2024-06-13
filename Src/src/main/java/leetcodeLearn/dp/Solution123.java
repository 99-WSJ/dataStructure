package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 123、买卖股票的最佳时机Ⅲ
 *
 * 你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author: wsj
 * @create: 2024-06-13 11:25
 **/
public class Solution123 {
    public static void main(String[] args) {
        //int[] nums = {7,1,5,3,6,4};
        int[] nums = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit1(nums));
    }

    private static int maxProfit1(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][5];
        // dp[i][0]代表第i天没有操作
        // dp[i][1]代表第i天第一次持有股票的最大现金
        // dp[i][2]代表第i天第一次不持有股票的最大现金
        // dp[i][3]代表第i天第二次持有股票的最大现金
        // dp[i][4]代表第i天第二次不持有股票的最大现金
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[len - 1][4];
    }
}
