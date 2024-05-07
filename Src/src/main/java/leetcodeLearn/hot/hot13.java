package leetcodeLearn.hot;

/**
 * @author wsj
 * @description  53 最大子数组和
 * @date 2024年04月26日 23:45
 */
public class hot13 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res =  maxSubArray(nums);
        System.out.println(res);
    }

    private static int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;
        for (int i : nums) {
            preSum = preSum + i;
            ans = Math.max(ans, preSum - minPreSum);
            System.out.println(ans);
            minPreSum = Math.min(minPreSum, preSum);
        }
        return ans;
    }
}
