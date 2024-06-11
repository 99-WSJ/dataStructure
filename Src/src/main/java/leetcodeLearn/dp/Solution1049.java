package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 1049. 最后一块石头的重量
 * 使用一维滚动数组，外层是遍历物品，内层遍历背包且倒序
 *
 * 二维dp数组在遍历顺序上，外层遍历物品 ，内层遍历背包容量 和
 * 外层遍历背包容量 ，内层遍历物品 都是可以的！
 * 但是先遍历物品更好理解。
 * @author: wsj
 * @create: 2024-06-11 16:23
 **/
public class Solution1049 {
    public static void main(String[] args) {
        int[] nums = {2,4,1,2};
        int res = lastStoneWight(nums);
        System.out.println(res);
    }

    private static int lastStoneWight(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            //for(int k: dp) {
            //    System.out.print(k + " ");
            //}
            //System.out.println();
        }
        return sum - 2*dp[target];
    }

}
