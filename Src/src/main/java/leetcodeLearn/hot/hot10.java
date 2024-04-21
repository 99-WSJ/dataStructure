package leetcodeLearn.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsj
 * @description 560 和为K的子数组
 * @date 2024年04月21日 17:00
 */
public class hot10 {
    public static void main(String[] args) {
//        int[] nums = {1,2,2,4,5,0,0,7,9};
        int[] nums = {3,4,7,2,-3,1,4,2};
//        int[] nums = {1,1,1};
        int k = 7;
        int res = fuc2(nums,k);
//        int res = fuc(nums,k);
        System.out.println(res);
    }

    private static int fuc(int[] nums, int k) {
        // 滑动窗口
        int count = 0;
        int res = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res + nums[i];
            while(res > k && l <= i) {
                res = res - nums[l];
                l++;
            }
            if(res == k) {
                count ++;
            }

        }
        return count;
    }

    public static int fuc2(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum,
                    preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }



}
