package leetcodeLearn.interview150;


/**
 * @author wsj
 * @description: 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @date 2024年08月09日 21:43
 */
public class Solution189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        func(k, nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }

    }
    static void func(int k, int[] nums) {
        // 整体翻转，翻转k % n前面的部分，翻转 k % n后面的部分
        if(k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);


    }
    static void reverse(int[] nums, int start, int right) {
        while(start < right) {
            int temp = nums[start];
            nums[start++] = nums[right];
            nums[right--] = temp;
        }
    }
}
