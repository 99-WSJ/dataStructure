package leetcodeLearn.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Src
 * @description: 无重复字符的最长字串
 * @author: wsj
 * @create: 2024-09-23 15:21
 **/
public class Solution3 {
    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "bbbbb";
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                // 将 left 更新到字符 arr[i] 上次出现位置的下一个位置
                // 不能left++
                left = Math.max(left, map.getOrDefault(arr[i], 0) + 1);
            }

            map.put(arr[i], i);
            System.out.println(i - left + 1);
            res = Math.max(res, i - left + 1);
        }
        return res;

    }
}
