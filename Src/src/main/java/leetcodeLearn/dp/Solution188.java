package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 188、买卖股票的最佳时机IV
 * 可以买卖k次
 * @author: wsj
 * @create: 2024-06-13 13:09
 **/
public class Solution188 {
    public static void main(String[] args) {
        //int[] nums = {7,1,5,3,6,4};
        int[] nums = {3,3,5,0,0,3,1,4};
        int k = 2;
        System.out.println(maxProfit2(nums, k));
    }

    private static int maxProfit2(int[] prices, int k) {
        if (prices.length == 0) return 0;

        // [天数][股票状态]
        // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
        int len = prices.length;
        int[][] dp = new int[len][k*2 + 1];

        // dp数组的初始化, 与版本一同理
        for (int i = 1; i < k*2; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < k*2 - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][k*2];
    }
}
