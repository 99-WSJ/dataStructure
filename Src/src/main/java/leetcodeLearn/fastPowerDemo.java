package leetcodeLearn;

/**
 * @program: Src
 * @description: 快速幂
 * @author: wsj
 * @create: 2024-09-25 14:10
 **/
public class fastPowerDemo {
    // 快速幂算法
    public static long fastPower(long base, long exponent) {
        long res = 1;
        while(exponent > 0) {
            if((exponent & 1) == 1) {
                res = res  * base;
            }
            base *= base;
            exponent >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        long base = 2;
        long exponent = 11;
        long result = fastPower(base, exponent);
        System.out.println(base + "的" + exponent + "次方是: " + result); // 输出: 1024
    }
}
