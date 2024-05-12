package leetcodeLearn.hot.half1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wsj
 * @description 438 找到字符串中所有字母异位词
 * @date 2024年04月21日 16:09
 */
public class hot9 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
//        String s = "abab";
//        String p = "ab";
        List<Integer> list = fuc(s, p);
        System.out.println(list);

    }

    private static List<Integer> fuc(String s, String p) {
        List<Integer> list =new ArrayList<>();
        char[] p1 = p.toCharArray();
        Arrays.sort(p1);
        String pp = new String(p1);
        for (int  i= 0; i < s.length() - p.length() + 1; i = i+1) {
            String s1 = s.substring(i, i + p.length());
            char[] ch = s1.toCharArray();
            Arrays.sort(ch);
            String s2 = new String(ch);
            if(pp.equals(s2)) {
                list.add(i);
            }

        }
        return list;

    }
}
