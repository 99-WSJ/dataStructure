package leetcodeLearn.dp;

import java.util.concurrent.ForkJoinPool;

/**
 * @program: Src
 * @description: 零钱兑换2, 求组合数
 * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
 *
 * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
 * @author: wsj
 * @create: 2024-06-12 10:54
 **/
public class Solution518 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int amount = 4;
        System.out.println(change(amount, nums));
    }
    public static int change(int amount, int[] coins) {
        //递推表达式
        int[] dp = new int[amount + 1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
                System.out.print("j=" + j + "   " + dp[j] + " ");
            }
            //for (int k = 0; k <= amount; k++) {
            //    System.out.print(dp[k] + " ");
            //}
            System.out.println();
        }

        //for (int j = 0; j <= amount; j++) { // 遍历背包容量
        //    for (int i = 0; i < coins.length; i++) { // 遍历物品
        //        if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
        //        System.out.print("j=" + j + "   " + dp[j] + " ");
        //    }
        //    System.out.println();
        //}


        return dp[amount];
    }
}
