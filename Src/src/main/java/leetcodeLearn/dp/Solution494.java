package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 494 目标和
 * @author: wsj
 * @create: 2024-06-11 17:27
 **/
public class Solution494 {
    public  static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int s = 3;
        System.out.println(findTargetSumWays(nums,s));

    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        //如果target的绝对值大于sum，那么是没有方案的
        if (Math.abs(target) > sum) {
            return 0;
        }
        //如果(target+sum)除以2的余数不为0，也是没有方案的
        if ((target + sum) % 2 == 1) {
            return 0;
        }

        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
            //for(int k: dp) {
            //    System.out.print(k + " ");
            //}
            //System.out.println();
        }

        return dp[bagSize];
    }
}
