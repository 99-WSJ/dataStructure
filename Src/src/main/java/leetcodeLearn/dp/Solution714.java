package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 714、买卖股票的最佳时机含手续费
 * 可以多次买卖，但是收手续费
 * @author: wsj
 * @create: 2024-06-13 13:28
 **/
public class Solution714 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        //int[] nums = {7,6,5,4,3,2};
        int fee = 1;
        System.out.println(maxProfit1(nums, fee));
    }

    private static int maxProfit1(int[] prices, int fee) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        // dp[i][0]代表第i天持有股票的最大现金
        // dp[i][1]代表第i天不持有股票的最大现金
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]); // 注意这里是和121. 买卖股票的最佳时机唯一不同的地方。
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] -fee);
        }
        return Math.max(dp[length - 1][1], dp[length - 1][0]);
    }
}
