package leetcodeLearn.hot.fifty;

import java.util.*;

/**
 * @author wsj
 * @description: 练习
 * @date 2025年01月11日 17:57
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        if(nums[0] > 0) return;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1])  continue;
            int left = i+1, right = nums.length-1;
            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(res);
    }
}
