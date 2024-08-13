package leetcodeLearn.interview150;

/**
 * @program: Src
 * @description: 跳跃游戏2
 * @author: wsj
 * @create: 2024-08-10 11:10
 **/
public class Solution45 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,0,1};
        System.out.println(func(nums));
    }
    static int func(int[] nums) {
        int len = nums.length;
        int maxRight = 0;
        int count = 0;
        int end = 0;
        for(int i = 0; i < len - 1; i++) {
            maxRight = Math.max(maxRight, i + nums[i]);
            if (i == end) {
                end = maxRight;
                count++;
            }
        }
        return count;
    }
}
