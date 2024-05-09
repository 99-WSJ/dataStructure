package leetcodeLearn.hot;

/**
 * @author wsj
 * @description  153、寻找旋转排序数组中的最小值
 * @date 2024年04月28日 0:07
 */
public class hot67 {
    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {2,1};
        int target =4;
        int res = findMin(nums);
        System.out.println(res);
    }

    private static int findMin(int[] nums) {
        // 找出第一个大小顺序突变的位置
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] > nums[0]) {
                left = mid + 1;
            } else if(nums[mid] == nums[0]) {
                return nums[0];
            } else  {
                right = mid - 1;
                res = right + 1;
            }
        }

        return nums[res];
    }
}
