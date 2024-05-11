package leetcodeLearn.hot;

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
        if( m == 1) {
            res.add(new ArrayList<>());
        }
        return res;
    }
}
