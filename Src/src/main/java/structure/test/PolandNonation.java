package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNonation {
    public static void main(String[] args) {
        String suffixExpress1 = "3 4 + 5 x 6 -";
        String suffixExpress = "4 5 x 8 - 60 + 8 2 / +";
        List<String> list = getListString(suffixExpress);
        int res = calculate(list);
        System.out.println("计算结果=" + res);

    }

    public static List<String> getListString(String suffixExpress) {
        String[] split = suffixExpress.split(" ");
        List<String> list = new ArrayList<String>();
        for(String  ele: split) {
            list.add(ele);
        }
        return list;
    }

    /**
     *
     * @param ls
     * @return
     */

    public static int calculate(List<String> ls) {      // "3 4 + 5 x 6 -";
        Stack<String> stack = new Stack<String>();
        for (String item : ls) {
            if (item.matches("\\d+")) {   //正则表达式，匹配多位数
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("x")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop()) ;
    }
}
