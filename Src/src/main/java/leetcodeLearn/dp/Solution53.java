package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 53、最大子数组和
 *
 * 给定一个整数数组 nums ，找到一个
 * 具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author: wsj
 * @create: 2024-06-13 16:45
 **/
public class Solution53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(func(nums));
        // 贪心
        //int[] nums = {-2};
        //int sum = 0;
        //int max = Integer.MIN_VALUE;
        //int min = 0;
        //for(int num : nums) {
        //    sum += num;
        //    max = Math.max(sum - min, max);
        //    min = Math.min(min, sum);
        //}
        //System.out.println(max);
    }

    private static int func(int[] nums) {
        // dp[i] 表示以nums[i] 为结尾时的最大子数组和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
