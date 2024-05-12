package leetcodeLearn.hot.half2;

/**
 * @author wsj
 * @description 55. 跳跃游戏
 * @date 2024年05月12日 22:30
 */
public class hot78 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
