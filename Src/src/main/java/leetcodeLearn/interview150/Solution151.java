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
        s = s.trim();
        String[] str = s.split(" ");
        int index = str.length - 1;
        StringBuilder res = new StringBuilder();
        while(index >= 0) {
            if(!str[index].equals("")) {
                res.append(" ");
                res.append(str[index]);
            }
            index--;
        }
        return res.toString().trim();

    }
}
