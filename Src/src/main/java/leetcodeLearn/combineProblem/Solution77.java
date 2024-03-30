package leetcodeLearn.combineProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿叙
 * 77题 组合
 */
public class Solution77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracing(n, k, 1);
        return res;
    }

    private void backTracing(int n, int k, int startIndex) {
        if(path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = startIndex; i <= n -(k - path.size())+1; i++) {
            path.add(i);
            backTracing(n,k,i+1);
            path.removeLast();
        }
    }

}
