package leetcodeLearn.hot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author wsj
 * @description
 * @date 2024年04月18日 16:16
 */
public class Solution128 {
    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {0,0,1 ,3,2,5,6,7,8,9};
        int[] nums = {1,0,-1};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;
        if(nums.length == 2) return Math.abs(nums[1] -nums[0])==1 ? 2:1;
        Set<Integer> set = new HashSet<>();
        for(int num : nums ) {
            set.add(num);
        }
//        int[] m = new int[set.size()];
        IntStream intStream = set.stream().mapToInt(Integer::intValue);
        int[] m = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(m);
        int count = 0;
        int j =0;
        for (int i = 0; i < m.length-1; i++) {
            if(m[i+1] - m[i] != 1) {
                j = i + 1;
            }
            count = Math.max(count, i - j + 2);

        }
        return count;
    }

}
