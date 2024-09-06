package examfinal.yonyou;

/**
 * @program: Src
 * @description:
 * 小友获得了一个超能力 -- 点石成金:只要用手指点一下地面，
 * 以接触点为中心的正方形区域都会变成金子。但是该能力有一个限制:
 * 碰到墙壁或已经变成金子的地面时，本次点石成金的过程就会停止。
 * 小友每次使用点石成金的能力，都会消耗1单位能量。
 * 现在小友处在一个大小为 nxm 的矩形房间内，
 * 他想消耗最少的能量把整个房间的地面都变成金子，请问这个最小值是多少单位?
 * 补充说明
 * 1.房间的边长都为整数，且1<= n, m <= 30;2.假设小友每次使用点石成金，
 * 都可以把一个正整数边长的区域变成金子
 * @author: wsj
 * @create: 2024-09-06 18:46
 **/

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的房间大小
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 调用函数计算最少使用能量的次数
        int result = minEnergy(n, m);

        // 输出结果
        System.out.println(result);
    }
    public static int minEnergy1(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int side = Math.min(i, j);
                dp[i][j] = 1 + dp[i - side][j] + dp[i][j - side];
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
            }
        }

        return dp[n][m];
    }

    public static int minEnergy(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        int side = Math.min(n, m);
        return 1 + minEnergy(n - side, m) + minEnergy(n, m - side);
    }
}
