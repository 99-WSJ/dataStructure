package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 213、打家劫舍2
 * 打家劫舍升级版，考虑首尾相连，成环
 * @author: wsj
 * @create: 2024-06-12 17:01
 **/
public class Solution213 {
    public static void main(String[] args) {
        //int[] nums = {1,6,1,9,1};
        int[] nums = {2,3,3};
        int res = func(nums,0, nums.length - 1);
        int res1 = func(nums,1, nums.length);
        System.out.println(res + " " + res1);
    }

    private static int func(int[] nums, int start, int end) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2 + start ; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end - 1 - start];

    }

}
