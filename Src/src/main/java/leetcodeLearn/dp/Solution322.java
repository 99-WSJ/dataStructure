package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 322、零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 * @author: wsj
 * @create: 2024-06-12 15:25
 **/
public class Solution322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int res = func(coins, amount);
        System.out.println(res);
    }

    private static int func(int[] coins, int amount) {
        // dp[j] 表示凑足金额为j情况下，硬币数最少
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        //初始化dp数组为最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];

    }
}
