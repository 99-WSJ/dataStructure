package examfinal.kedaxunfei;

/**
 * @program: Src
 * @description: 第一题
 * @author: wsj
 * @create: 2024-09-04 16:03
 **/

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        // 创建Scanner对象读取输入
        Scanner scanner = new Scanner(System.in);

        // 读取整数N
        int N = scanner.nextInt();

        // 生成并打印倒立金字塔
        for (int i = N; i > 0; i--) {
            // 打印每一行的内容
            for (int j = 0; j < i; j++) {
                System.out.print(N);
            }
            // 换行
            System.out.println();
        }

        // 关闭Scanner对象
        scanner.close();
    }
}
