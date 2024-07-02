package leetcodeLearn.dp;

import static leetcodeLearn.hot.hundred.hot77.maxProfit;

/**
 * @program: Src
 * @description: 121、买卖股票的最佳时机Ⅰ
 * 只能买卖一次
 * @author: wsj
 * @create: 2024-06-13 10:26
 **/
public class Solution121 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        //int[] nums = {7,6,5,4,3,2};
        System.out.println(func(nums));
        System.out.println(maxProfit1(nums));
    }

    private static int maxProfit1(int[] prices) {
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
            dp[i][0] = Math.max(dp[i -1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i -1][1], dp[i -1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }

    private static int func(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i] - min);
        }
        return max;
    }
}
