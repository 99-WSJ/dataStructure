package leetcodeLearn.hot.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wsj
 * @description 34、在排序数组中查找元素的第一个和最后一个位置
 * @date 2024年04月27日 21:39
 */
public class hot65 {
    public static void main(String[] args) {
//        int[] nums = {5,8,8,8,8,10};
//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {1,1,2};
//        int target = 8;
        int target = 1;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

    private static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        List<Integer> list = new ArrayList<>();
        while (left <= right) {
            int mid = (left + right) >> 1;
             if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else  {
                int min = nums.length -1;
                int max = 0;
                int mid2 = mid;
                if(mid - 1>=0 && nums[mid - 1] == target) {
                    while(mid - 1 >= left && mid -1 >= 0){
                        if(nums[mid - 1] == target) {
                            min = Math.min(min, mid -1);
                        } else {
                            break;
                        }
                        mid -=1;
                    }
                    list.add(min);
                }
                list.add(mid2);
                if(mid + 1<=nums.length - 1 && nums[mid2 + 1] == target) {
                    while(mid2 + 1 <= right && mid2 + 1 <= nums.length - 1){
                        if(nums[mid2 + 1] == target) {
                            max = Math.max(max, mid2 + 1);
                        } else {
                            break;
                        }
                        mid2 +=1;
                    }
                    list.add(max);
                }
                break;
            }
        }
        if(list.size() == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{list.get(0), list.get(list.size() - 1)};
    }
}
