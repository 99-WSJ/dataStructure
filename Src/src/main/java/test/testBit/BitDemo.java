package test.testBit;

/**
 * @author wsj
 * @description: 位运算
 * @date 2024年08月09日 22:40
 */
public class BitDemo {
    public static void main(String[] args) {
        int nums = 16;
        if((nums & 1) == 0){
            System.out.println("我是偶数");
        }
        if((nums & (nums - 1)) == 0){
            // 前提：x > 0;
            System.out.println("我是2的幂");
        }
        // 一个数 与 2的n次方 减 1  == 这个数对 2的 n次方 取余
    }
}
