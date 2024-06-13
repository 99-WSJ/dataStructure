package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 718. 最长重复子数组
 *
 * 给两个整数数组 nums1 和 nums2 ，
 * 返回两个数组中公共的 、长度最长的子数组的长度。
 *
 * @author: wsj
 * @create: 2024-06-13 15:11
 **/
public class Solution718 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {1,2,3,1,2};
        int len1 = nums1.length;
        int len2 = nums2.length;
        // dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，
        // 最长重复子数组长度为dp[i][j]。
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 0;
        int res = 0;
        for(int i = 1 ; i<=len1; i++) {
            for(int j = 1; j<=len2; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        System.out.println(res);
    }
}
