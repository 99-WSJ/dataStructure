package leetcodeLearn.interview150;

import java.util.HashMap;

/**
 * @author wsj
 * @description: 赎金信
 * @date 2024年08月20日 23:08
 */
public class Solution383 {
    public static void main(String[] args) {
        String s1 = "aaba";
        String s2 = "aab";
        System.out.println(canConstruct(s1, s2));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        return true;
    }

}
