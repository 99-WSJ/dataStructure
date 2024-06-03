package leetcodeLearn.hot.fifty;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

/**
 * @author wsj
 * @description 128、最长连续序列
 * 方法一：哈希表set，先去重
 * @date 2024年04月18日 16:16
 */

public class hot3 {
    public static void main(String[] args) {
       int[] nums = {100, 4, 200, 1, 3, 2};
       // int[] nums = {0,3,7,2,5,8,4,6,0,1};
       // int[] nums = {0,0,1 ,3,2,5,6,7,8,9};
       //  int[] nums = {1,0,-1};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
            System.out.println(num_set);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;

    }

}
