package leetcodeLearn.combine;

import java.util.*;

public class Solution40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> solution(int[] nums, int target) {
        if(nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        backTracing(nums, target, 0,0);
//        Set<List<Integer>> result = new HashSet<>();
//        result.addAll(res);
        return new ArrayList<>(res);
    }

    private void backTracing(int[] nums, int target, int sum,int startIndex) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i< nums.length && sum + nums[i] <= target; i++) {
            if(i>startIndex && nums[i]== nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            sum = sum + nums[i];
            backTracing(nums,target,sum, i + 1);
            path.removeLast();
            sum = sum - nums[i];
        }
    }

    public static void main(String[] args) {
        Solution40 s = new Solution40();
        List<List<Integer>> res = s.solution(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30);
        System.out.println(res);
    }

}
