package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description: 两数之和 II - 输入有序数组
 * @date 2024年08月16日 20:35
 */
public class Solution167 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 26;
        int[] res = twoSum2(nums, target);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        // 二分找到位置
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length-1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(target - nums[i] > nums[mid]) {
                    left = mid + 1;
                } else if(target - nums[i] == nums[mid]) {
                    return new int[] {i + 1, mid + 1};
                } else {
                    right = mid - 1;
                }
            };
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSum2(int[] nums, int target) {
        // 双指针
        int left = 0, right = nums.length - 1;
        while(left < right) {
            if(target > nums[left] + nums[right]) {
                left++;
            } else if(target < nums[left] + nums[right]) {
                right--;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        return new int[] {-1,-1};
    }

}
