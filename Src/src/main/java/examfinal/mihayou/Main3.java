package examfinal.mihayou;

/**
 * @program: Src
 * @description:
 * @author: wsj
 * @create: 2024-09-04 16:03
 **/

import java.util.*;

import java.util.*;

public class Main3 {
    static int n, m;
    static char[][] grid;
    static int[][] componentId;  // 用于标记每个格子所属的连通块ID
    static int[] componentSize;  // 用于存储每个连通块的大小
    static int currentComponentId = 0;
    static int[] dx = {1, -1, 0, 0};  // 四个方向
    static int[] dy = {0, 0, 1, -1};

    // 判断坐标是否在地图内
    static boolean inBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    // 使用DFS计算一个连通块的大小
    static int dfs(int x, int y, char type) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        componentId[x][y] = currentComponentId;  // 标记连通块ID
        int size = 0;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int cx = cell[0];
            int cy = cell[1];
            size++;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (inBounds(nx, ny) && grid[nx][ny] == type && componentId[nx][ny] == -1) {
                    componentId[nx][ny] = currentComponentId;
                    stack.push(new int[]{nx, ny});
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取地图大小
        n = scanner.nextInt();
        m = scanner.nextInt();
        grid = new char[n][m];
        componentId = new int[n][m];

        // 读取地图
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }

        // 初始化componentId为-1，表示未访问
        for (int i = 0; i < n; i++) {
            Arrays.fill(componentId[i], -1);
        }

        // 记录所有陆地连通块的大小
        List<Integer> landSizes = new ArrayList<>();

        // 计算所有陆地连通块
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '#' && componentId[i][j] == -1) {
                    currentComponentId++;
                    int size = dfs(i, j, '#');
                    landSizes.add(size);
                }
            }
        }

        //// 记录所有陆地连通块的大小
        //List<Integer> waterSizes = new ArrayList<>();
        //
        //// 计算所有陆地连通块
        //for (int i = 0; i < n; i++) {
        //    for (int j = 0; j < m; j++) {
        //        if (grid[i][j] == '.' && componentId[i][j] == -1) {
        //            currentComponentId++;
        //            int size = dfs(i, j, '.');
        //            waterSizes.add(size);
        //        }
        //    }
        //}

        // 将连通块大小存入数组，componentSize的索引是连通块ID
        componentSize = new int[currentComponentId + 1];
        for (int i = 0; i < landSizes.size(); i++) {
            componentSize[i + 1] = landSizes.get(i);
        }

        // 记录当前最大陆地连通块的大小
        int maxLandSize = 0;
        for (int size : landSizes) {
            maxLandSize = Math.max(maxLandSize, size);
        }

        // 尝试点燃每个大海格子
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    // 使用Set来避免重复计算相邻的陆地连通块
                    Set<Integer> adjacentComponents = new HashSet<>();
                    int newLandSize = 1;  // 将这个大海格子变成陆地

                    // 检查四个方向的相邻格子
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];

                        if (inBounds(ni, nj) && grid[ni][nj] == '#') {
                            int compId = componentId[ni][nj];
                            if (!adjacentComponents.contains(compId)) {
                                adjacentComponents.add(compId);
                                newLandSize += componentSize[compId];  // 累加相邻陆地连通块的大小
                            }
                        }
                    }

                    // 更新最大陆地连通块的大小
                    maxLandSize = Math.max(maxLandSize, newLandSize);
                }
            }
        }

        // 输出结果
        System.out.println(maxLandSize);
    }
}
