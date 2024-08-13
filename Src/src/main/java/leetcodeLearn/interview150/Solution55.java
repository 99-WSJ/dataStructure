package leetcodeLearn.interview150;

/**
 * @program: Src
 * @description: 55、跳跃游戏
 * @author: wsj
 * @create: 2024-08-10 10:25
 **/
public class Solution55 {
    public static void main(String[] args) {
        //int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        System.out.println(func(nums));
    }

    private static boolean func(int[] nums) {
        int len = nums.length;
        int maxRight = 0;
        for (int i = 0; i < len; i++) {
            if(maxRight < i) {
                return false;
            }
            maxRight = Math.max(maxRight, i + nums[i]);
        }
        return true;
    }

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[nums.length - 1];
    }

}
