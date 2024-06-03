package leetcodeLearn.hot.hundred;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author wsj
 * @description 20、有效的符号
 * @date 2024年05月09日 14:38
 */
public class hot69 {
    public static void main(String[] args) {
        // String s =  "()[]{}";
        String s =  "()[{}";
        boolean res = isValid(s);
        System.out.println(res);
    }

    private static boolean isValid(String s) {
        if(s.length() <= 1 || s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (map.containsKey(c)) {
                st.push(c);
            }
            if (map.containsValue(c)) {
                if (st.isEmpty() || map.get(st.peek()) != c) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();


    }
}
