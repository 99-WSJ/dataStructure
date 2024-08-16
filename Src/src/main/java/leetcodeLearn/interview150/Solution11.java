package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description: 盛最多水的容器
 * @date 2024年08月16日 21:24
 */
public class Solution11 {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    private static int maxArea(int[] nums) {
        // 由短边决定
        int res = 0;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            if(nums[left] > nums[right]) {
                res = Math.max(res, (right - left) * nums[right]);
                right --;

            }else {
                res = Math.max(res, (right - left) * nums[left]);
                left ++;
            }
        }
        return res;

    }
}
