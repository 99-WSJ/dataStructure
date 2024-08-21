package leetcodeLearn.interview150;

import java.util.Arrays;

/**
 * @author wsj
 * @description: TODO
 * @date 2024年08月21日 23:20
 */
public class Solution242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
