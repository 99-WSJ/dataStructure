package test.test1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wsj
 * @description
 * @date 2024年01月13日 18:26
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
//        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 15;
        Solution solution = new Solution();
        Set set = new HashSet<Integer>();
        set.add(target);
        System.out.println(set);
        int result = solution.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    public int minSubArrayLen(int target, int[] nums) {
        // {5,1,3,5,10,7,4,9,2,8};
        int length = 0;
        int temp = 0;
        int lengthTemp = Integer.MAX_VALUE;
        int count = 0;
        for (int p = 0; p < nums.length; p++) {
            for (int i = temp; i < nums.length; i++) {
                if(count < target) {
                    count = nums[i] + count;
                }
                if(count >= target) {
                    length = i - p + 1;
                    temp = i;
                    count = count - nums[p];

                    break;
                }
            }
//             if(count < target) {
//                 return 0;
//             }
            if(length < lengthTemp) {
                lengthTemp = length;
            }
            System.out.println("length  " + length);
            System.out.println("lengthTemp   "+ lengthTemp);

        }
        return lengthTemp;

    }
}
