package structure;

public class KMP {
    // 计算 next 数组
    private int[] computeNext(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < m - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    // KMP 算法匹配主串中的子串
    public int indexOf(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m == 0) return 0; // 空字符串是任何字符串的子串
        int[] next = computeNext(pattern);
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == m) {
            return i - j; // 返回匹配的起始位置
        } else {
            return -1; // 没有匹配
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String text = "ABABCABABABCABABABCABABABCABABABCABABABC";
        String pattern = "ABABCABAB";
        int index = kmp.indexOf(text, pattern);
        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}

