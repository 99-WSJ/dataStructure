package leetcodeLearn.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsj
 * @description: TODO
 * @date 2024年08月20日 23:24
 */
public class Solution205 {
    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "add";
        System.out.println(isIsomorphic(s1, s2));
    }

    private static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        // for (int i = 0; i < s1.length(); i++) {
        //     char c1 = s1.charAt(i);
        //     char c2 = s2.charAt(i);
        //     if (s1.indexOf(c1) != s2.indexOf(c2)) {
        //         return false;
        //     }
        // }
        // return true;
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;


    }
}
