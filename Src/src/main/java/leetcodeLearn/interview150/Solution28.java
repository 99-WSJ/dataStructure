package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description: TODO
 * @date 2024年08月14日 22:45
 */
public class Solution28 {
    public static void main(String[] args) {
        // String  haystack = "sadbutsad", needle = "sad";
        String  haystack = "leetcode", needle = "leeto";
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle) {
        // 暴力
        return haystack.indexOf(needle);
        // KMP


    }
}
