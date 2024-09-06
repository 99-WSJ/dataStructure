package examfinal.yonyou;

/**
 * @program: Src
 * @description: 第一题
 * 小友玩了一款打怪游戏，因为开了科技，所以小友可以直接秒杀怪物，
 * 同时获得这一关卡怪物的所有能量值。小友可以使用新获得的能量值进行跳关，
 * 能量值为最大的跳关数量，跳关后会清空所有能量。因为开了科技，
 * 导致有些关卡没有刷新怪物，会让小友在这一关内无法新获得能量，
 * 从而被困死在这一关。给你一个关卡序列，
 * 请你帮助小友可以顺利打到最后一个boss关卡，拿到通关奖励。
 * @author: wsj
 * @create: 2024-09-06 18:46
 **/

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int n = input.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        boolean[] dp = new boolean[n]; 
        dp[0] = true; 

        for (int i = 0; i < n; i++) {
            if (dp[i]) { 
                int max = arr[i];
                for (int j = 1; j <= max; j++) {
                    if (i + j < n) {
                        dp[i + j] = true; 
                    }
                }
            }
        }
        System.out.println(dp[n - 1] ? "true" : "false");
    }
}
