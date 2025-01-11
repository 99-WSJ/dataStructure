package leetcodeLearn.hot.hundred;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Src
 * @description: 腐烂的橘子
 * @author: wsj
 * @create: 2024-10-29 11:03
 **/
public class hot52 {
    static boolean[][] visited;
    static boolean isValid(int x, int y, int m, int n) {
        return (x >= 0) && (x < m) && (y>=0) && (y<n);
    }
    static int[][] distance = {{-1,0}, {1,0}, {0,1},{0,-1}};
    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        //int[][] grid = {{2,1,1}, {0,1,1}, {1,0,1}};
        //int[][] grid = {{1,2}};
        int count = 0;
        int sum = 0;
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    que.offer(new int[] {i,j});
                    visited[i][j] = true;
                }
                if(grid[i][j] != 0) {
                    sum++;
                }
            }
        }

        while(!que.isEmpty()) {
            int size = que.size();
            while(size > 0) {
                int[] temp = que.poll();
                for (int i = 0; i < distance.length; i++) {
                    int x = temp[0] + distance[i][0];
                    int y = temp[1] + distance[i][1];
                    if (isValid(x, y, m, n) && !visited[x][y] && grid[x][y] == 1) {
                        que.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
                size--;
            }
            count++;

        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if(visited[i][j]) {
                    sum--;
                }
            }
        }
        System.out.println(sum == 0 ? count - 1 : -1);

    }
}
