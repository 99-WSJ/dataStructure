package structure;

import java.util.Arrays;


/**
 * KMP 字符串匹配
 * 预处理：O(m)，其中 m 是模式串的长度。
 * 匹配：O(n)，其中 n 是文本串的长度。
 * 总时间复杂度：O(m + n)。
 */
public class KMP {
    // 计算 next 数组

    private int[] computeNext(String pattern) {
        int m = pattern.length();  // ABABCABAB
        int[] next = new int[m]; // next[i]: 最长相同前缀和后缀的长度
        next[0] = 0; // 第一个字符的 Next 值为 0
        int i = 1, j = 0; // i 指向当前字符，j 指向匹配的前缀

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                // 如果当前字符匹配，Next 值为 j + 1
                j++;
                next[i] = j;
                i++;
            } else {
                if (j != 0) {
                    // 如果不匹配，且 j 不为 0，回退到 next[j-1]
                    j = next[j - 1];
                } else {
                    // 如果 j 为 0，Next 值为 0
                    next[i] = 0;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }

    // KMP 算法匹配主串中的子串
    public int indexOf(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m == 0) return 0; // 空字符串是任何字符串的子串
        int[] next = computeNext(pattern);
        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                // 当前字符匹配，继续比较下一个字符
                i++;
                j++;
                if (j == m) {
                    // 模式串完全匹配，返回起始位置
                    return i - j;
                }
            } else {
                if (j != 0) {
                    // 不匹配时，利用 Next 数组跳过已经匹配的部分
                    // next数组记录了模式串的特征（最长相等前缀和后缀的长度）
                    j = next[j - 1];
                } else {
                    // j 为 0，模式串第一个字符不匹配，移动文本串指针
                    i++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String text = "ABABDABABCA";
        String pattern = "ABABC";
        int index = kmp.indexOf(text, pattern);
        if (index != -1) {
            System.out.println("模式串的索引为： " + index);
        } else {
            System.out.println("模式串不存在");
        }
        System.out.println(text.indexOf(pattern));
    }
}

