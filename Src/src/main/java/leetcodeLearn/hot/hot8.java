package leetcodeLearn.hot;

import java.util.HashMap;

/**
 * @author wsj
 * @description 3、无重复字符的最长字串
 * @date 2024年04月21日 15:34
 */
public class hot8 {
    public static void main(String[] args) {
        String s = "bbb";
        int res = fuc( s);
        System.out.println(res);
    }

    private static int fuc(String s) {
        int res = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i -j +1);

        }
        return res;
    }
}
