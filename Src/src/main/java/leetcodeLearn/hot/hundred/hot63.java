package leetcodeLearn.hot.hundred;

/**
 * @author wsj
 * @description  35 搜索插入位置
 * @date 2024年04月27日 20:59
 */
public class hot63 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        int res = serachInsert(nums, target);
        System.out.println(res);
    }

    private static int serachInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
