package leetcodeLearn.hot;

/**
 * 189 轮转数组
 */
public class hot15 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }
    public static void rotate(int[] nums, int k) {
        if(k <= 0) {
            return;
        }
        int temp = nums[nums.length - 1];
        System.arraycopy(nums, 0, nums, 1, nums.length - 1);
        nums[0] = temp;
        k--;
        rotate(nums,k);

    }
}
