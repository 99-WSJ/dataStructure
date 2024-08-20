package leetcodeLearn.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsj
 * @description: 螺旋矩阵
 * @date 2024年08月20日 21:38
 */
public class Solution54 {
    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));

    }
    public  static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length-1, up = 0, down = matrix.length-1;
        int flag = 0;
        while(left <= right && up <= down) {
            if (flag == 0) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[up][i]);
                }
                up++;
                flag = (flag + 1) % 4;
            } else if(flag == 1) {
                for (int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
                flag = (flag + 1) % 4;
            } else if(flag == 2) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
                flag = (flag + 1) % 4;
            } else {
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
                flag = (flag + 1) % 4;
            }
        }
        return res;
    }
}
