package leetcodeLearn.interview150;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wsj
 * @description: 最长公共前缀
 * @date 2024年08月13日 21:34
 */
public class Solution14 {
    public static void main(String[] args) {
        // String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};
        // String[] strs = {"dog"};
        List<String> list = Arrays.asList(strs);
        StringBuilder s = new StringBuilder("");
        if(list.size() <= 1) {
            System.out.println(strs[0]);
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int len = list.get(0).length();
        for(int i = 0; i<len; i++) {
            char temp = list.get(0).charAt(i);
            boolean flag = false;
            for(int j = 1; j < list.size(); j++) {
                if(list.get(j).charAt(i) != temp) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if(flag) {
                System.out.println(list.get(0).substring(0, i));
            } else {
                break;
            }


        }

    }

}
