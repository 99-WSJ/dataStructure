package leetcodeLearn.hot.half2;

/**
 * @author wsj
 * @description 169. 多数元素   Boyer-Moore 投票算法
 * @date 2024年05月12日 14:09
 */
public class hot97 {
    public static void main(String[] args) {
        // int[] nums = {2,2,1,1,1,2,2};
        int[] nums = {1,2,1,2,3,1};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
