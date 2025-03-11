package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description: 151 反转字符串中的单词
 * @date 2024年08月13日 22:39
 */
public class Solution151 {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        StringBuilder str = removeSparse(s);
        reverse(str, 0, str.length() - 1);
        reverse2(str);

        return str.toString();
    }

    private static void reverse2(StringBuilder str) {
        int n = str.length();
        int start = 0;
        for (int end = 0; end <= n; end++) {
            if (end == n || str.charAt(end) == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
    }

    private static void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }

    private static StringBuilder removeSparse(String s) {
        StringBuilder str = new StringBuilder();
        int l = 0, r = s.length() - 1;
        while (s.charAt(l) == ' ') l++;
        while (s.charAt(r) == ' ') r--;
        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if (c != ' ' || str.charAt(str.length() - 1) != ' ') {
                str.append(c);
            }
        }
        return str;
    }
}
