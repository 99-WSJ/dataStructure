package leetcodeLearn.interview150;

import javax.swing.text.html.parser.TagElement;

/**
 * @program: Src
 * @description: 搜索旋转排序数组
 * @author: wsj
 * @create: 2024-09-28 23:11
 **/
public class Solution33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,0,1,2,3};
        int target = 0;
        System.out.println(func(nums, target));
    }

    private static int func(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
       if(nums.length == 1){
           return nums[0] == target ? 0 : -1;
       }
       int left = 0, right = nums.length - 1;
       while(left <= right) {
           int mid = (left + right) / 2;
           if(nums[mid] == target) {
               return mid;
           }
           if(nums[0] < nums[mid]) {
               if(nums[0] <= target && target < nums[mid]) {
                   right = mid -1;
               } else {
                   left = mid + 1;
               }
           } else {
               if(nums[mid] < target && target <= nums[nums.length - 1]) {
                   left = mid + 1;
               } else {
                   right = mid - 1;
               }
           }
       }
        return -1;

    }
}
