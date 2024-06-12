package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 组合总和4
 * 给定一个由正整数组成且不存在重复数字的数组，
 * 找出和为给定目标正整数的组合的个数。
 * @author: wsj
 * @create: 2024-06-12 13:37
 **/
public class Solution377 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        int res = func(nums, target);
        System.out.println(res);
    }

    private static int func(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
            
        }
        return dp[target];
    }
}
