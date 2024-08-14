package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description: 判断子序列
 * @date 2024年08月14日 23:40
 */
public class Solution392 {
    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
        int p = 0, q = 0;
        while(p < t.length() && q < s.length()) {
            if(p - q > t.length() - s.length()) {
                System.out.println("=======");
                break;
            }
            if(t.charAt(p) == s.charAt(q)) {
                q++;
            }
            p++;
        }
        return q == s.length();

    }
}
