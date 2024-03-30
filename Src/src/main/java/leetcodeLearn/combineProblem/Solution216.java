package leetcodeLearn.combineProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int n, int k) {
        // n为组合之和，k为深度，path的长度
        backTracing(k,n,0,1);
        return res;
    }

    private void backTracing(int k, int n, int sum, int startIndex) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum != n) {
                return;
            }
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            // 数字1-9 i最大为9
            path.add(i);
            sum = sum + i;
            backTracing(k, n, sum, i + 1);
            path.removeLast();
            sum = sum - i;
        }
    }

    public static void main(String[] args) {
        Solution216 s = new Solution216();
        List<List<Integer>> res = s.combinationSum3(7, 3);
        System.out.println(res);
    }


}
