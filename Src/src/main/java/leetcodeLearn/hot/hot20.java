package leetcodeLearn.hot;

import java.util.List;

/**
 * @author wsj
 * @description 48、旋转图像
 * @date 2024年05月08日 21:08
 */
public class hot20 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    // 围绕（i，j） ==>  （j，n-i-1）
    private static void rotate(int[][] matrix) {
       // int[][] m = new int[matrix.length][matrix[0].length];
       // for (int i = 0; i < matrix.length; i++) {
       //     for (int j = 0; j < matrix[0].length; j++) {
       //         m[j][matrix.length-i-1] = matrix[i][j];
       //     }
       //
        int n = matrix.length;
        // 转置
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //水平反转
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left ++;
                right --;
            }
        }



    }
}
