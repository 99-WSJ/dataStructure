package leetcodeLearn.hot.half2;

import java.util.Scanner;

/**
 * @author wsj
 * @description 搜索二维矩阵
 * @date 2024年04月27日 21:02
 */
public class hot64 {
    public static void main(String[] args) {
//        int[][] matrix = new int[3][4];
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 4; j++) {
//                matrix[i][j] = scanner.nextInt();
//            }
//        }
        int target = 10;
        Boolean b = searchMatrix(matrix, target);
        System.out.println(b);

    }

    private static Boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] data = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i*n + j] = matrix[i][j];
            }
        }
        int left = 0, right = data.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return true;
            }
            else if(data[mid] > target) {
                right = mid - 1;
            }
            else if(data[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
