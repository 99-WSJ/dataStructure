package leetcodeLearn.hot.half1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wsj
 * @description  239 滑动窗口最大值
 * @date 2024年04月22日 12:34
 */
public class hot11 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = fuc(nums, k);
        for (int i : res)  {
            System.out.print(i + " ");
        }
    }


    private static int[] fuc(int[] nums, int k) {
        // 两层for超时
        /*
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i - k + 1; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i - k + 1] = max;
        }
        return res;
        */
        // 前缀和
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1];
            }


        });

        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
