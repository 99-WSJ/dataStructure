package leetcodeLearn.stack;

import java.util.Stack;

/**
 * @author wsj
 * @description: 逆波兰表达式
 * @date 2025年03月11日 14:12
 */
public class Solution150 {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11",
                "*", "/", "*", "17", "+", "5", "+"};
        Stack<String> st = new Stack<>();
        int res = 0, temp1 = 0, temp2 = 0;
        for (String s : tokens) {
            if (!st.isEmpty() && s.equals("+")) {
                temp1 = Integer.parseInt(st.pop());
                temp2 = Integer.parseInt(st.pop());
                res = temp2 + temp1;
                st.push(String.valueOf(res));
            } else if (!st.isEmpty() && s.equals("-")) {
                temp1 = Integer.parseInt(st.pop());
                temp2 = Integer.parseInt(st.pop());
                res = temp2 - temp1;
                st.push(String.valueOf(res));
            } else if (!st.isEmpty() && s.equals("*")) {
                temp1 = Integer.parseInt(st.pop());
                temp2 = Integer.parseInt(st.pop());
                res = temp2 * temp1;
                st.push(String.valueOf(res));
            } else if (!st.isEmpty() && s.equals("/")) {
                temp1 = Integer.parseInt(st.pop());
                temp2 = Integer.parseInt(st.pop());
                res = temp2 / temp1;
                st.push(String.valueOf(res));
            } else {
                st.push(s);
            }
        }
        System.out.println(st.peek());

    }
}
