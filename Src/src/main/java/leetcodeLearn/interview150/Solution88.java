package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description 合并两个有序数组
 * @date 2024年08月08日 21:44
 */
public class Solution88 {
    public static void main(String[] args) {
        int[] nums1 = { 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        //merge(nums1, m, nums2, n);
        merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1;
        while (p >= 0 || q >= 0) {
            if (p == -1) {
                nums1[p + q + 1] = nums2[q];
                q--;
            } else if (q == -1) {
                nums1[p + q + 1] = nums1[p];
                p--;
            } else if (nums2[q] > nums1[p]) {
                nums1[p + q + 1] = nums2[q];
                q--;
            } else {
                nums1[p + q + 1] = nums1[p];
                p--;
            }
        }
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int slow = 0;
        for (int i = 0; i < length; i++) {
            if(nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }

        return slow;
    }
}

    /**
     * public void merge(int[] nums1, int m, int[] nums2, int n) {
     *         int p1 = m - 1, p2 = n - 1;
     *         int tail = m + n - 1;
     *         int cur;
     *         while (p1 >= 0 || p2 >= 0) {
     *             if (p1 == -1) {
     *                 cur = nums2[p2--];
     *             } else if (p2 == -1) {
     *                 cur = nums1[p1--];
     *             } else if (nums1[p1] > nums2[p2]) {
     *                 cur = nums1[p1--];
     *             } else {
     *                 cur = nums2[p2--];
     *             }
     *             nums1[tail--] = cur;
     *         }
     *     }
     *
     * 作者：力扣官方题解
     *  O(n)  O(1)
     */
