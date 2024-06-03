package leetcodeLearn.hot.hundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsj
 * @description 118. 杨辉三角
 * @date 2024年05月09日 17:18
 */
public class hot82 {
    public static void main(String[] args) {
        int m = 5;
        System.out.println(generate(m));
    }

    private static List<List<Integer>> generate(int m) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i <= m; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j < i ; j++) {
                if(j == 0 || j == i -1) {
                    // path.add(j, 1);
                    path.add(1);
                } else {
                    // path.add(j, res.get(res.size() - 1).get(j - 1) + res.get(res.size() - 1).get(j));
                    path.add(res.get(res.size() - 1).get(j - 1) + res.get(res.size() - 1).get(j));
                }
            }
            res.add(path);
            System.out.println(res);
        }


        return res;
    }
}
