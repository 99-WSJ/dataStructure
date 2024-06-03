package leetcodeLearn.hot.fifty;

import java.util.*;

/**
 * @author wsj
 * @description  49、字母异位词分组
 * @date 2024年04月21日 16:11
 */
class hot2 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
//    public  static List<List<String>> groupAnagrams(String[] strs) {
//        Map<Integer[], List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            Integer[] key = new Integer[26];
//            List<String> list = new ArrayList<>();
//            for (int j = 0; j < str.length(); j++) {
//                key[str.charAt(j) - 'a']++;
//            }
//            if (map.get(key) != null) {
//                map.get(key).add(str);
//            } else {
//                list.add(str);
//                map.put(key, list);
//            }
//
//        }
//        return new ArrayList<>(map.values());
//
//
//    }
public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    Arrays.sort(strs);
    for (String str : strs) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray); // 将字符串排序，确保相同字母异序词得到相同的键
        String sortedStr = new String(charArray);
        List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
        list.add(str);
        map.put(sortedStr, list);
    }
    return new ArrayList<>(map.values());
}
}