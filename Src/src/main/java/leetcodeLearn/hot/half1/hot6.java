package leetcodeLearn.hot.half1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wsj
 * @description  15、三数之和 双指针
 * @date 2024年04月21日 14:55
 */
public class hot6 {
    static List<List<Integer>> list  = new ArrayList<>();
    static List<Integer> path  = new ArrayList<>();
    static int add =0;
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,-1,-4};
        Arrays.sort(nums);
        fuc(nums,0);
        List<List<Integer>> list2  = new ArrayList<>();
        for(List<Integer> i : list) {
            if(!list2.contains(i)) {
                list2.add(i);
            }
        }
        System.out.println(list2);
    }

    private static void fuc(int[] nums, int startIndex) {
        if(path.size() > 3) {
            return;
        }
        if(path.size() == 3) {
            if(add == 0) {
                list.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = startIndex; i<nums.length;i++ ) {
            path.add(nums[i]);
            add += nums[i];
            fuc(nums,i+1);
            add -=nums[i];
            path.remove(path.size() - 1);
        }

    }
}
