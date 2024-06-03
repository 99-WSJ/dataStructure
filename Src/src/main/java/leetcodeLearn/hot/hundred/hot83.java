package leetcodeLearn.hot.hundred;

/**
 * @author wsj
 * @description 198. 打家劫舍
 * @date 2024年05月11日 14:16
 */
public class hot83 {
    public static void main(String[] args) {
        // int[] m = new int[]{1,2,3,1};
        int[] m = new int[]{2,7,9,3,1};
        System.out.println(rob(m));
    }
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
