package leetcodeLearn.hot.hundred;

/**
 * @author wsj
 * @description 75. 颜色分类
 * @date 2024年05月12日 14:35
 */
public class hot98 {
    public static void main(String[] args) {
        // int[] nums = {2,2,1,1,1,2,2};
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for(int i: nums) {
            System.out.println(i);
        }
    }

    public static void sortColors(int[] nums) {
        // 冒泡排序
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

    }
}
