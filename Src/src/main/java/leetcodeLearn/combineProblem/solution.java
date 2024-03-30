package leetcodeLearn.combineProblem;
import java.util.Scanner;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int result = 101;
        List<Integer> vec = new ArrayList<>();
        dfs(0, 0, 0, a, x, result, vec);

        if (result == 101) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static void dfs(int index, int sum, int ans, int[] a, int x, int result, List<Integer> vec) {
        if (sum == x) {
            result = Math.min(result, ans);
        } else if (sum > x) {
            return;
        }

        if (index >= a.length) {
            return;
        }

        // 一次
        List<Integer> next = new ArrayList<>(vec);
        next.add(a[index] / 2);
        dfs(index + 1, sum + a[index] / 2, ans + 1, a, x, result, next);

        // 多次
        next = new ArrayList<>(vec);
        next.add(a[index]);
        dfs(index + 1, sum + a[index], ans + 1, a, x, result, next);

        // 不选
        dfs(index + 1, sum, ans, a, x, result, vec);
    }


}
