package leetcodeLearn.stack;

import java.util.Stack;

/**
 * @author wsj
 * @description: 删除字符串中的所有相邻重复项
 * @date 2025年03月11日 13:54
 */
public class Solution1047 {
    public static void main(String[] args) {
        String s = "abbaca";

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && s.charAt(i) == st.peek()) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        String str = "";

        while (!st.isEmpty()) {
            str = st.pop() + str;
        }
        System.out.println(str);
    }

}
