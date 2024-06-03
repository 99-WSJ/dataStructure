package leetcodeLearn.hot.hundred;

/**
 * @author wsj
 * @description 136. 只出现一次的数字
 * @date 2024年05月09日 15:41
 *       算术运算符：+、-、*、/、%、++、- -
 *       赋值运算符：=、+=、-=、*=、/=等等
 *       位运算符：~、&、|、^
 *       逻辑运算符：！、&&、||
 *       关系运算符：>、<、>=、<=、= = 、!=
 *       移位运算符>>、<<、>>>（无符号右移）
 *
 */
public class hot96 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,3};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int single = 0;
        for(int num: nums) {
            single ^= num;
        }
        return single;

    }
}
