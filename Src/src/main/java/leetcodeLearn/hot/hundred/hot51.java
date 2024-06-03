package leetcodeLearn.hot.hundred;

/**
 * @author wsj
 * @description  200 岛屿数量
 * @date 2024年04月24日 21:06
 */
public class hot51 {

    static boolean[][] visit;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int count = 0;
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','1','1','0'},
                {'1','1','1','1','0'},{'1','1','1','1','0'}};
        char[][] grid1 = {{'1','1','0','0','0'},{'1','1','0','0','0'},
                {'0','0','1','0','0'},{'0','0','0','1','1'}};
        int res = numIslands(grid1);
        System.out.println(res);
    }

//    private static int numIslands(char[][] grid) {
//        int res = 0;
//        visit = new boolean[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if(!visit[i][j] && grid[i][j] == '1') {
//                    res++;
//                    bfs(grid, i, j);
//                }
//            }
//        }
//        return  res;
//    }
//
//    private static void bfs(char[][] grid, int y, int x) {
//        Deque<int[]> q = new ArrayDeque<>();
//        q.offer(new int[]{y,x});
//        visit[y][x] = true;
//        while(!q.isEmpty()) {
//            int[] temp = q.poll();
//            int m = temp[0];
//            int n = temp[1];
//            for (int[] ints : move) {
//                int nextY = m + ints[0];
//                int nextX = n + ints[1];
//                if (nextY < 0 || nextY >= grid.length || nextX < 0 || nextX >= grid[0].length) {
//                    continue;
//                }
//                if (!visit[nextY][nextX] && grid[nextY][nextX] == '1') {
//                    q.offer(new int[]{nextY, nextX});
//                    visit[nextY][nextX] = true;
//                }
//            }
//        }
//    }

    private static int numIslands(char[][] grid) {
        int res = 0;
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count = 0;
                    res ++;
                    dfs(grid, i, j);
                    num = Math.max(num , count);
                }
            }
        }
        return num;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j <0||j>=grid[0].length || grid[i][j] == '0') {
            return ;
        }
        grid[i][j] = '0';
        count++;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

}
