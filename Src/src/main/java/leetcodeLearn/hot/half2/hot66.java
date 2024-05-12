package leetcodeLearn.hot.half2;

/**
 * @author wsj
 * @description 33、搜索旋转排序数组
 * @date 2024年04月27日 23:16
 */
public class hot66 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target =4;
        int res = search(nums,target);
        System.out.println(res);
    }

    private static int search(int[] nums, int target) {
        int[] data = new int[2*nums.length];
        System.arraycopy(nums, 0, data, 0, nums.length);
        System.arraycopy(nums, 0, data, nums.length, nums.length);
        int left = 0;
        int right = data.length - 1;
        for (int i = 0; i < data.length - 1; i++) {
            if(data[i] < data[0]) {
                left = i;
                right = i + nums.length - 1;
                break;
            }
        }
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(data[mid] > target) {
                right -= 1;
            } else if(data[mid] < target) {
                left += 1;
            } else {
                return mid > nums.length - 1 ? mid - nums.length : mid;
            }
        }
        return -1;
    }
}
