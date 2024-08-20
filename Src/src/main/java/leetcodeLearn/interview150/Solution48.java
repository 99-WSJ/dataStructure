package leetcodeLearn.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsj
 * @description: 旋转图像
 * @date 2024年08月20日 22:11
 */
public class Solution48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
    }

    public static void rotate(int[][] matrix) {
        // x, y ==> y, len-1-x
        // 转置再水平翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix[0].length - 1;
            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = temp;
            }
        }
    }
}
