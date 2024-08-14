package leetcodeLearn.interview150;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wsj
 * @description: Z字形变换
 * @date 2024年08月14日 22:01
 */
public class Solution6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int rows = 3;
        System.out.println(convert(s, rows));
    }

    private static String convert(String s, int rows) {
        if(rows == 1) {
            return s;
        }
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            res.add(new StringBuilder());
        }
        int i = 0;
        boolean flag = false;
        for(char c : s.toCharArray()) {
            res.get(i).append(c);
            if(i == 0 || i == rows - 1) {
                flag = !flag;
            }
            i += flag ? 1 : -1;
        }
        // StringBuilder result = new StringBuilder();
        // res.forEach(result::append);
        return res.stream().map(StringBuilder::toString).collect(Collectors.joining());
        // return result.toString();
    }
}
