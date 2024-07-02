package leetcodeLearn.dp;

import java.util.Arrays;

/**
 * @program: Src
 * @description: 674. 最长连续递增序列
 *
 * 双指针解法
 * 动态规划
 *
 * 不连续递增子序列的跟前0-i 个状态有关，
 * 连续递增的子序列只跟前一个状态有关
 *
 * @author: wsj
 * @create: 2024-06-13 14:18
 **/
public class Solution674 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int res =1, l = 0;
        int count;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                count = i - l + 1;
                res = Math.max(res, count);
            } else {
                l = i;
            }
        }
        System.out.println(res);
    }
    //dp 动态规划
    public static int func(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        //可以注意到，這邊的 i 是從 0 開始，
        // 所以會出現和卡哥的C++ code有差異的地方，
        // 在一些地方會看到有 i + 1 的偏移。
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }
}
