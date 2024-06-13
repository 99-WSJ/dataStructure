package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 122、买卖股票的最佳时机Ⅱ
 * 可以多次买卖，
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * @author: wsj
 * @create: 2024-06-13 11:21
 **/
public class Solution122 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        //int[] nums = {7,6,5,4,3,2};
        System.out.println(maxProfit1(nums));
    }

    private static int maxProfit1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[][] dp = new int[length][2];
        // dp[i][0]代表第i天持有股票的最大现金
        // dp[i][1]代表第i天不持有股票的最大现金
        dp[0][0] = -nums[0];
        dp[0][1] = 0;
        for(int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]); // 注意这里是和121. 买卖股票的最佳时机唯一不同的地方。
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
        }
        return dp[length - 1][1];
    }

}
