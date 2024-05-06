package leetcodeLearn.hot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wsj
 * @description 73 矩阵置零
 * @date 2024年04月27日 20:56
 */
public class hot18 {
    public static void main(String[] args) {
        int[][] m = new int[][]{{0, 1, 0}, {1, 0, 1}, {1, 1, 1}};
        func(m);
        for (int[] ints : m) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static void func(int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        int p = matrix.length;
        int q = matrix[0].length;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (matrix[i][j] == 0) {
                    set.add(j);        // 列号
                    set1.add(i);       // 行号
                }
                if (set.size() == q || set1.size() == p) {
                    break;
                }
            }
        }
        for (int i : set1) {
            for (int j = 0; j < q; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : set) {
            for (int i = 0; i < p; i++) {
                matrix[i][j] = 0;
            }
        }

    }
}
