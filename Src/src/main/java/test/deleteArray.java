package test;

import java.util.*;

public class deleteArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int length = nums.length;

        for (int fast = 0; fast < length; fast++) {
            int val = nums[slow];   //
            if(val != nums[fast]) {
                slow = slow + 1;
                nums[slow] = nums[fast];
            }
        }
        return slow;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int q = 0;
        int p = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        while (p < nums.length) {
            while (sum < target && q < nums.length) {
                sum = sum + nums[q];
                q++;
            }
            q--;
            length = Math.min(length, q - p + 1);
            q++;
            sum = sum - nums[p];
            p++;
        }
        return length;

    }
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return null;
        }
        // 排序
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return null;
            }
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (right > left) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (right > left && nums[right] == nums[right - 1])
                        right--;
                    while (right > left && nums[left] == nums[left + 1])
                        left++;
                    left++;
                    right--;
                }
            }
        }
        return result;

    }


    public static void main(String[] args) {
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {-1,0,1,2,-1,-4};
        int targrt = 7;

//        String str = "Hello, World!";
//        char[] charArray = str.toCharArray();
        deleteArray deleteArray = new deleteArray();
        int len = deleteArray.minSubArrayLen(targrt, nums);
        System.out.println(len);
        deleteArray.isHappy(19);
        List<List<Integer>> lists = deleteArray.threeSum(nums);
        System.out.println(lists);

    }
}
