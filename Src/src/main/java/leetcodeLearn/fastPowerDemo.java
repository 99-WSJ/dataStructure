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
    public static double myPow(double x, int n) {
        double res = 1.0;
        boolean flag = true;
        if(n==0) return res;
        if(n < 0) {
            flag = false;
            n = -n;
            System.out.println(n);
        }
        while(n > 0){
            if(n % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            n = n / 2;
        }
        return flag?res : 1.0/res;

    }


    public static void main(String[] args) {
        long base = 2;
        long exponent = 11;

        long result = fastPower(base, exponent);
        double res = myPow(2.0, -2147483647);
        System.out.println(res);
        System.out.println(base + "的" + exponent + "次方是: " + result); // 输出: 1024
    }
}
