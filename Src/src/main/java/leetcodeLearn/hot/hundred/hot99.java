package leetcodeLearn.hot.hundred;

/**
 * @author wsj
 * @description 31 下一个排列
 * @date 2024年05月12日 15:01
 */
public class hot99 {
    public static void main(String[] args) {
        // int[] nums = {2,2,1,1,1,2,2};
        // int[] nums = {1,1,5};
        int[] nums = {3,2,1};
        nextPermutation(nums);
        for(int i: nums) {
            System.out.println(i);
        }
    }

    public static void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        //12354 下个排列是 12435

        //  第一步：从尾部到前部，找到第一个升序的俩个值，i-1和i，那i-1就是我们要置换的位置，在12354里我们找到3这个值
        // 跟谁换？跟右边倒数第一个大于它的值换（第二步）
        int pos = -1;
        for (int i = nums.length-1; i >= 1; i--) {
            if(nums[i-1] < nums[i] ){
                pos = i-1;
                break;
            }
        }
        //没有更大的排列了，题目要求返回最小排列，就直接整体排序
        if(pos == -1){
            reverse(nums, 0);
            return;
        }
        //第二步：找到第一个大于 nums[pos]的值 交换，12354里交换3和4变成 12453
        for (int i = nums.length-1; i > pos; i--) {
            if(nums[pos] < nums[i] ) {
                swap(nums, pos, i);
                break;
            }
        }
        //第三步：给 [pos+1,length) 到转一下，12453变成12435
        reverse(nums, pos+1);
    }

    private static void reverse(int[] nums, int pos) {
        for (int i = pos , j = nums.length-1; i < j; i++,j--) {
            swap(nums, j, i);
        }
    }

    private static void swap(int[] nums, int pos, int i) {
        int t = nums[i];
        nums[i] = nums[pos];
        nums[pos] = t;
    }
}
