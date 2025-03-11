package mistakeEasy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsj
 * @description:
 * 易错点：值传递（引用传递、String不可变）
 * Arrays.toString(): 数组变成string后，开始和末尾会增加'[' ']'
 * String操作的时候最好转成StringBuilder处理，否则返回值new string()会一直创建对象
 * @date 2025年03月09日 19:10
 */
public class Demo1 {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};


    public static void main(String[] args) {
        Demo1 ex = new Demo1();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);

        int i = 0;
        ex.fermin(i);
        // 值传递
        // 函数fermin在栈空间创建局部变量i=0，和main函数里面的i没有关系
        // 如果是引用类型，则创建引用对象，该对象指向main函数的对象
        i++;

        System.out.println(i); // 打印 i 的值
        ex.reverseWords("sky is blue");
        System.out.println(ex.ch);
    }

    void fermin(int i) {
        i++;
    }
    public void change(String str, char[] ch) {   // 无返回值的String
        // 引用对象需要注意的是String, String不可变性
        // String 是 Java 中的不可变对象。当你对 str 重新赋值时（如 str = "test ok";），实际上是创建了一个新的 String 对象，而不会修改原来的 String 对象
        str = "test ok";
        ch[0] = 'g';
    }

    public String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        System.out.println(sb.toString());
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        System.out.println(sb.toString());
        // 3.反转各个单词
        reverseEachWord(sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
