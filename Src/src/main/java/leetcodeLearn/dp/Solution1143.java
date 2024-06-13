package leetcodeLearn.dp;

/**
 * @program: Src
 * @description: 1143.最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，
 * 返回这两个字符串的最长公共子序列的长度
 *
 * @author: wsj
 * @create: 2024-06-13 15:28
 **/
public class Solution1143 {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        dp[0][0] = 0;
        for(int i = 1; i<=c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if(c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[c1.length][c2.length]);

    }
}
