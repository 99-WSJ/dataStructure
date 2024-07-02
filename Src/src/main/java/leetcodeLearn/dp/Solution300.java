package leetcodeLearn.dp;

import java.util.Arrays;

/**
 * @program: Src
 * @description: 300. 最长递增子序列
 * 给你一个整数数组 nums ，
 * 找到其中最长严格递增子序列的长度。
 * @author: wsj
 * @create: 2024-06-13 13:58
 **/
public class Solution300 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        //int[] nums = {4,10,4,3,8,9};
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);


        }
        System.out.println(res);
    }
}
