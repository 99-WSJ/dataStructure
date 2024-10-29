package leetcodeLearn.hot.hundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsj
 * @description 回溯 46、全排列
 * @date 2024年04月24日 21:08
 */
public class hot55 {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        dfs(nums, list);
        System.out.println(res);
    }
    static void dfs(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            //不能使用res.add(list),因为list最终随着递归结束，变为[]，引用类型
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, list);
            list.remove(list.size() - 1);
        }
    }
}
