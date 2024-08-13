package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description: 58、最后一个单词的长度
 * @date 2024年08月13日 20:58
 */
public class Solution58 {
    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        int count = 0;
        int index = 0;
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] != ' ') {
                index = i;
                break;
            }
        }
        for (int i = index; i >= 0; i--) {
            if (c[i] != ' ') {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);

    }
}
