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
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int res = 0;
        for(int x : set) {
            if(set.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            while(set.contains(y)) {
                y++;
            }
            res = Math.max(res, y - x);
        }
        return res;

    }

}
