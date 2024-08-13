package leetcodeLearn.interview150;

import java.util.Arrays;

/**
 * @program: Src
 * @description: H指数
 * @author: wsj
 * @create: 2024-08-10 11:26
 **/
public class Solution274 {
    public static void main(String[] args) {
        //int[] nums = {3,0,6,1,5};
        int[] nums = {2,1,2,5,1};
        System.out.println(func2(nums));
    }

    /**
     * 用例：70/82
     * @param citations
     * @return
     */
    static int func(int[] citations) {
        int len = citations.length;
        if(len == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        Arrays.sort(citations);
        // 找到第一个不为0的下标
        int index = 0;
        for(int i = 0; i<len; i++) {
            if(citations[i] > 0) {
                index = i;
                break;
            }
        }
        if(citations[index] > len - index) {
            return len - index;
        }
        int res = 0;
        for (int i = index; i < len; i++) {
            int temp = citations[i];
            int count = 0;
            for (int j = i; j < len; j++) {
                if (citations[j] >= temp) {
                    count++;
                }
                if (count >= temp) {
                    res = Math.max(res, temp);
                    break;
                }
            }
        }
        return res;
    }


    static int func2(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;

    }

}
