package leetcodeLearn.hot.fifty;

import java.util.ArrayList;
import java.util.List;

/**
 *  54、 螺旋数组
 */
public class hot19 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = order(matrix);
        System.out.println(res);
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;

    }
    private static List<Integer> order(int[][] martrix) {
        List<Integer> res = new ArrayList<>();
        int rows = martrix.length;
        int cols = martrix[0].length;
        if(cols == 0) {
            return res;
        }
        int total = rows * cols;
        int[][] direction = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visit = new boolean[rows][cols];
        int  row = 0, col = 0, directionIndex = 0;
        for (int i = 0; i < total; i++) {
            visit[row][col] = true;
            res.add(martrix[row][col]);
            int nextRow = row + direction[directionIndex][0];
            int nextCol = col + direction[directionIndex][1];
            if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visit[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return res;
    }
}
