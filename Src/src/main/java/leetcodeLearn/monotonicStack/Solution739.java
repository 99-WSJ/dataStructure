package leetcodeLearn.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: Src
 * @description: 每日温度
 * @author: wsj
 * @create: 2024-10-04 15:05
 **/
public class Solution739 {
    //输入: temperatures = [73,74,75,71,69,72,76,73]
    //输出: [1,1,4,2,1,1,0,0]
    public static void main(String[] args) {
        //int[] nums = {73,74,75,71,69,72,76,73};
        int[] nums = {30,40,50,60};
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] res = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                res[st.peek()] = i - st.peek();
                st.pop();
            }
            // 递减栈
            st.push(i);
        }
        for(int i : res) {
            System.out.print(i + " ");
        }

    }
}
