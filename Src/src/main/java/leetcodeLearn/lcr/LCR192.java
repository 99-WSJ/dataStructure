package leetcodeLearn.lcr;


/**
 * @program: Src
 * @description: 字母转数字
 * @author: wsj
 * @create: 2024-09-11 23:48
 **/
public class LCR192 {
    public static void main(String[] args) {
        int i = myAtoi("   -42  ");
        System.out.println(i);

    }
    public static int myAtoi(String str) {
        char[] arr = str.trim().toCharArray();
        int i = 1, sign = 1;
        int index = Integer.MAX_VALUE / 10;
        int res = 0;
        if(arr[0] == '-') {
            sign = -1;
        } else if(arr[0] != '+'){
            i = 0;
        }
        for (int j = i; j < arr.length; j++) {
            if(arr[j] < '0' || arr[j] > '9') {
                break;
            }
            if(res > index || res == index && arr[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (arr[j] - '0');
        }
        return sign * res;


    }
}
