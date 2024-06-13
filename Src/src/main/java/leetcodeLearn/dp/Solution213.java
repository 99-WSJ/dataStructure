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
        int res = func(nums,0, nums.length - 2);
        int res1 = func(nums,1, nums.length - 1);
        System.out.println(res + " " + res1);
    }

    private static int func(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 0) return 0;
        if (n == 1) return nums[start];
        if (n == 2) return Math.max(nums[start], nums[end]);

        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return Math.max(dp[n - 1], dp[n - 2]);

    }

}
