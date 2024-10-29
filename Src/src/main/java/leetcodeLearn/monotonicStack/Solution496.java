package leetcodeLearn.monotonicStack;

import sun.java2d.pipe.SpanIterator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: Src
 * @description: 单调栈，下一个更大元素
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置
 * 右侧的第一个 比 x 大的元素。
 * @author: wsj
 * @create: 2024-10-04 15:04
 **/
public class Solution496 {

    //输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
    //输出：[-1,3,-1]
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!st.isEmpty() && nums2[i] > nums2[st.peek()]){
                if(map.containsKey(nums2[st.peek()])) {
                    res[map.get(nums2[st.peek()])] = nums2[i];
                }
                st.pop();
            }
            st.push(i);
        }
        for(int i : res) {
            System.out.print(i + " ");
        }

    }
}
