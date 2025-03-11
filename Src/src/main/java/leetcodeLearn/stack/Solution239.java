package leetcodeLearn.stack;

/**
 * @author wsj
 * @description: 239、滑动窗口最大值元素
 * @date 2025年03月11日 15:54
 */
public class Solution239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1, -3,5,3,6,7};
        int k = 3;

        // 求和最大, 时间复杂度O(n)
        // int sum = 0, max;
        // for (int i = 0; i < k; i++) {
        //     sum += nums[i];
        // }
        // int l = 1;
        // max = sum;
        // while(l < nums.length - k + 1) {
        //     sum = sum - nums[l-1] + nums[l+k-1];
        //     max = Math.max(max, sum);
        //     l++;
        // }
        // System.out.println(max);

        // 最大值元素 三种方法（优先队列、双端队列、Deque）


    }
}
