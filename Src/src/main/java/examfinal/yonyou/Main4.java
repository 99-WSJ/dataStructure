package examfinal.yonyou;

/**
 * @program: Src
 * @description:
 * 小友是公司的产品研发经理，负责安排员工在多个研发项目之间进行工作和实验。
 * 小友希望在确保员工完成研发任务的同时，最大化他们进行创新实验的时间。
 * 规则和限制:
 * 1.可以安排员工在 N 个研发项目之间进行工作和实验，
 * 这些项目用0 到 N-1 的索引表示。一开始，员工在索引为0的项目，
 * 并且那天是星期一。
 * 2.项目之间通过任务安排相连，这些任务安排用 NxN 矩阵 tasks(不一定是对称的)表示，
 * tasks[]l]代表项目i到项目j的任务安排状态。如果没有项目i到项目j的任务安排，
 * tasksli]=0;否则，tasks[i]]=1。同时，对于所有的i，tasks[i][i]=0。
 * 3.你有K周(每周7天)的时间来安排员工的工作和实验。
 * 员工每天最多只能转换一次任务，并且只能在每周的星期一上午转换任务。
 * 由于转换时间很短，我们不考虑转换时间的影响。
 * 4.对于每个项目，不同的星期员工可以进行创新实验的时间是不同的，
 * 给定一个NxK矩阵 days 代表这种限制，
 * days[i][j] 代表员工在第j个星期在项目i能进行创新实验的最大天数
 * 5.如果员工从项目 A转换到项目 B，并在当天进行实验，
 * 实验时间将计入 B 项目当周的实验时间。
 * 目标
 * 给定 tasks 矩阵和 days 矩阵，安
 * 排研发工作以使K周内员工可以进行创新实验的最长时间。
 * 输入描述
 * N 第一行输入 N
 * 输入 NxN 的矩阵 task 的各个元素
 * 输入K代表K周输入 NxK矩阵 days 的各个元素
 * 输出描述
 * K周内员工可以进行创新实验的最长时间
 * @author: wsj
 * @create: 2024-09-06 18:46
 **/

import java.util.Scanner;

//public class Main4 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int N = scanner.nextInt();
//
//        int[][] tasks = new int[N][N];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                tasks[i][j] = scanner.nextInt();
//            }
//        }
//
//        int K = scanner.nextInt();
//
//        int[][] days = new int[N][K];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < K; j++) {
//                days[i][j] = scanner.nextInt();
//            }
//        }
//
//
//        int[][] dp = new int[K][N];
//
//
//        for (int i = 0; i < N; i++) {
//            dp[0][i] = days[i][0];
//        }
//
//        for (int week = 1; week < K; week++) {
//            for (int cur = 0; cur < N; cur++) {
//                dp[week][cur] = 0;
//                for (int pre = 0; pre < N; pre++) {
//                    if (tasks[pre][cur] == 1) {
//                        dp[week][cur] = Math.max(dp[week][cur], dp[week - 1][pre] + days[cur][week]);
//                    }
//                }
//            }
//        }
//
//        int res = 0;
//        for (int i = 0; i < N; i++) {
//            res = Math.max(res, dp[K - 1][i]);
//        }
//
//        System.out.println(res);
//    }
//}

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();


        int[][] tasks = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tasks[i][j] = scanner.nextInt();
            }
        }


        int k = scanner.nextInt();


        int[][] days = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                days[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[n][k];


        for (int i = 0; i < n; i++) {
            dp[i][0] = days[i][0];
        }

        for (int week = 1; week < k; week++) {
            for (int i = 0; i < n; i++) {

                dp[i][week] = dp[i][week - 1] + days[i][week];

                for (int j = 0; j < n; j++) {
                    if (tasks[j][i] == 1) {
                        dp[i][week] = Math.max(dp[i][week], dp[j][week - 1] + days[i][week]);
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i][k - 1]);
        }

        System.out.println(res);
    }
}
