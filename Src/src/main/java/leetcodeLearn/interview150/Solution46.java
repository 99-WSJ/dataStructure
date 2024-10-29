package leetcodeLearn.interview150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Src
 * @description: 全排列
 * @author: wsj
 * @create: 2024-09-28 23:46
 **/
public class Solution46 {
    static List<List<Integer>> res = new ArrayList<>();


    private static void func(int[] nums, LinkedList<Integer> list) {

        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            func(nums, list);
            list.removeLast();
        }

    }
}
