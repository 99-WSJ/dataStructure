package leetcodeLearn.hot.fifty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsj
 * @description  1、两数之和
 * @solutions
 *
 * 哈希表
 *
 * @date 2024年04月21日 16:11
 */
public class hot1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 22;
        int[] res = twoSum(nums, target);
        for(int i : res) {
            System.out.print(i  + " ");
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);

        }
        return new int[] {-1};
    }
}
