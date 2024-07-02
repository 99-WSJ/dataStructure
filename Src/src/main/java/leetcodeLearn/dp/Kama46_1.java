package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 01背包2
 * @author: wsj
 * @create: 2024-06-11 14:21
 **/
public class Kama46_1 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        func(weight, value, bagSize);
    }

    private static void func(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i : dp) {
            System.out.print(i + " ");
        }
    }
}
