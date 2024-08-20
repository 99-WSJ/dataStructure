package leetcodeLearn.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsj
 * @description: 矩阵置零
 * @date 2024年08月20日 22:23
 */
public class Solution73 {
    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3},{4,0,6},{7,8,9}};
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
    }
    public static void setZeroes(int[][] matrix) {
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        for (int i = 0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }

        rowList.forEach(item -> {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[item][i] = 0;
            }
        });
        colList.forEach(item -> {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][item] = 0;
            }
        });
    }
}
