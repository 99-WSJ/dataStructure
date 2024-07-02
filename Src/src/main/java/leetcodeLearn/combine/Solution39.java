package leetcodeLearn.combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿叙
 */
public class Solution39 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> solution(int[] nums, int target) {
        if(nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backTracing(nums, target, 0,0);
        return res;
    }

    private void backTracing(int[] nums, int target, int sum,int startIndex) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i< nums.length; i++) {
            path.add(nums[i]);
            sum = sum + nums[i];
            backTracing(nums,target,sum, i);
            path.removeLast();
            sum = sum - nums[i];
        }
    }

    public static void main(String[] args) {
        Solution39 s = new Solution39();
        List<List<Integer>> res = s.solution(new int[]{2, 3, 6, 7}, 7);
        System.out.println(res);
    }

}
