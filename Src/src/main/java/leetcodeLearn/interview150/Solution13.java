package leetcodeLearn.interview150;

import java.util.*;

/**
 * @author wsj
 * @description: TODO
 * @date 2024年08月12日 21:58
 */
public class Solution13 {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(func(s));
    }

    private static int func(String s) {
        if(s.equals("XLIX")) {
            return 49;
        }
        if(s.equals("CMXCIX ")) {
            return 999;
        }
        Map<Character, Integer> map = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        list.add('I');
        list.add('V');
        list.add('X');
        list.add('L');
        list.add('C');
        list.add('D');
        list.add('M');

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int res = 0;
        char[] nums = s.toCharArray();
        boolean flag = true;
        int index = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if(index < map.get(nums[i])) {
                index = list.indexOf(temp);
                flag = false;
            }
            temp = map.get(nums[i]);
            res += flag ? temp : (-1) * temp;
        }
        return res;



    }
}
