package leetcodeLearn.stack;

import java.util.*;

/**
 * @author wsj
 * @description: 347、前 K 个高频元素
 * @date 2025年03月11日 17:25
 */
public class Solution347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        Deque<Integer> que = new LinkedList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1]- o1[1]);
        for(Map.Entry<Integer, Integer> t :map.entrySet()) {
            pq.offer(new int[] {t.getKey(), t.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
    }
}
