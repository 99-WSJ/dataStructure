package examfinal.mihayou;

/**
 * @program: Src
 * @description: 第一题
 * @author: wsj
 * @create: 2024-09-04 16:03
 **/

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = -1, res = -1;
        for (int i = n; i <= m; i++) {
            String str = Integer.toString(i);
            int p = 0;
            int q = 0;

            for (char c : str.toCharArray()) {
                if (c == '4') {
                    p++;
                } else if (c == '6') {
                    q++;
                }
            }

            int sum = p + q;
            if (sum > max || (sum == max && i > res)) {
                max = sum;
                res = i;
            }
        }
        System.out.println(res);
    }
}
