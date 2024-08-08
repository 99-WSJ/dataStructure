package leetcodeLearn.hot.hundred;

/**
 * @author wsj
 * @description Floyd 判圈算法
 * @date 2024年05月12日 16:06
 */
public class hot100 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,3,2};
        System.out.println(findDuplicate(nums));

    }

    private static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
