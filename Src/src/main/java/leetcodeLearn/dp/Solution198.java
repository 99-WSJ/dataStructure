package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 198.打家劫舍
 * 未成环
 * @author: wsj
 * @create: 2024-06-12 16:50
 **/
public class Solution198 {
    public static void main(String[] args) {
        //int[] nums = {1,2,3,1};
        int[] nums = {2,3,7,9};
        int res = func(nums);
        System.out.println(res);
    }

    private static int func(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];

    }

}
