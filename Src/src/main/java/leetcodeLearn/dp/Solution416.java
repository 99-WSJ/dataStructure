package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 416：分割等和子集
 * @author: wsj
 * @create: 2024-06-11 15:08
 **/
public class Solution416 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(func(nums));
    }
    static boolean func(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum/2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                System.out.print(dp[j] + " ");

            }
            if(dp[target] == target) {
                return true;
            }

        }
        return dp[target] == target;
        /*
        //dp数组的打印结果 for test case 1.
            0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            0, 1, 1, 1, 1, 5, 6, 6, 6, 6, 6, 6,
            0, 1, 1, 1, 1, 5, 6, 6, 6, 6, 6, 11,
            0, 1, 1, 1, 1, 5, 6, 6, 6, 6, 10, 11,
         */

    }
}
