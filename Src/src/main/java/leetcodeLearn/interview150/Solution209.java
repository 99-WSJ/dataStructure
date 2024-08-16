package leetcodeLearn.interview150;

import java.util.HashMap;

/**
 * @author wsj
 * @description: 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，
 *并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @date 2024年08月16日 21:45
 */
public class Solution209 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
        String s = "abcabcbb";
        int res = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j +1);
        }
        System.out.println(res);
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 注意left移动和sum--的先后顺序
            // 注意是大于等于
            while(sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


}
