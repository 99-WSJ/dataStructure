package leetcodeLearn.stack;

import java.util.*;

/**
 * @author wsj
 * @description: 239、滑动窗口最大值元素
 * @date 2025年03月11日 15:54
 */
public class Solution239 {
    public static void main(String[] args) {

        int[] nums = {1, 3, 1, 2, 0, 5};
        // int[] nums = {1,3,-1, -3,5,3,6,7};
        // int[] nums = {1,2,3, 4,5,6,7,8,9,10,11,12,13,14};
        int k = 3;

        // 最大值元素 三种方法（优先队列、双端队列、Deque）
        // 1、优先队列
        // int[] res = func(nums, k);
        // 2、Deque单调队列
        // int[] res = func2(nums, k);
        // 3、双端队列
        int[] res = func3(nums, k);
        for (int i : nums) {
            System.out.print(i + " ");
        }


    }

    private static int[] func3(int[] nums, int k) {
       Deque<Integer> deque = new ArrayDeque<>();
       int[] res = new int[nums.length - k + 1];

       return res;

    }

    private static int[] func2(int[] nums, int k) {
        DeQueue que = new DeQueue();
        for (int i = 0; i < k; i++) {
            que.add(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = que.peek();
        for (int i = k; i < nums.length; i++) {
            que.poll(nums[i - k]);
            que.add(nums[i]);
            res[i - k + 1] = que.peek();
        }
        return res;
    }

    static int[] func(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                // 如果单调递增，堆会一直增大，堆顶一直更新，且不会poll()
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
}

class DeQueue {
    Deque<Integer> deque;

    DeQueue() {
        deque = new LinkedList<Integer>();
    }

    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    boolean Empty() {
        return deque.isEmpty();
    }

    int peek() {
        return deque.peek();
    }

}
