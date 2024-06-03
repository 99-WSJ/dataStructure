package leetcodeLearn.hot.hundred;

import java.util.Arrays;

/**
 * @author wsj
 * @description 322、零钱兑换
 * @date 2024年05月11日 15:46
 */
public class hot85 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        // dp[i] 代表金额为i的情况下，需要的最少硬币数;
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        Arrays.fill(dp, max);
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for (int coin : coins) {
            //正序遍历：完全背包每个硬币可以选择多次
            for (int j = coin; j <= amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }
}
