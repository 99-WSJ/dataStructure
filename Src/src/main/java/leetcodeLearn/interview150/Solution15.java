package leetcodeLearn.interview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Src
 * @description: 三数之和
 * @author: wsj
 * @create: 2024-09-28 21:14
 **/

public class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = nums.length - 1;
            int sum = nums[i] + nums[left] + nums[right];
            while(left < right) {
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right ++;
                    }
                    left++;
                    right--;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
