package leetcodeLearn.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsj
 * @description: 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * @date 2024年08月21日 23:05
 */
public class Solution290 {
    public static void main(String[] args) {
        String  pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));

    }

    public static boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(map1.containsKey(pattern.charAt(i)) && !map1.get(pattern.charAt(i)).equals(s1[i]) ||
                    map2.containsKey(s1[i]) && !map2.get(s1[i]).equals(pattern.charAt(i))) {
                return false;
            }
            map1.put(pattern.charAt(i), s1[i]);
            map2.put(s1[i], pattern.charAt(i));
        }
        return true;
    }
}
