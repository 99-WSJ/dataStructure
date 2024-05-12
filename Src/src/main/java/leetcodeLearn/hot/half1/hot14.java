package leetcodeLearn.hot.half1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿叙
 * 56、合并区间
 */
public class hot14 {
    public static void main(String[] args) {
        int[][] nums = new int[][] {{1,3},{2,6},{0,3},{15,18}};
        int[][] res = merge(nums);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int m = intervals.length;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if(list.size() != 0 && intervals[i][0] <= list.get(list.size() - 1)) {
                list.remove(list.size() - 1);
                list.add(intervals[i][1]);
            } else {
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
            }

        }
        int[][] res = new int[list.size() / 2][2];
        for (int i = 0; i < list.size(); i = i+2) {
            res[i/2] = new int[]{list.get(i), list.get(i + 1)};
        }
        return res;
    }
}
