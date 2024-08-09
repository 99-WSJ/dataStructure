package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description 删除有序数组中的重复项 II
 * @date 2024年08月09日 20:43
 */
public class Solution80 {
    public static void main(String[] args) {
        // int[] nums = {1,1,1,2,2,3};
        int[] nums = {0,0,1,1,1,1,2,3,3};
        func(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }

    static void func(int[] nums) {
        int slow = 2, fast = 2;
        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        System.out.println(slow);
    }
}
