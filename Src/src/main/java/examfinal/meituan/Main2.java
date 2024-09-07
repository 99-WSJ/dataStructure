package examfinal.meituan;

/**
 * @program: Src
 * @description:
 * 对于给定的由 n个节点构成，根节点为 1的有根树中，我们定义节点u 和v是”相似的节点”，
 * 当且仅当节点u 的子节点数量 son。与节点v的子节点数量 son相等。输出”相似的节点“的对数。
 * @author: wsj
 * @create: 2024-09-06 18:46
 **/

import java.util.*;



public class Main2 {
    static List<List<Integer>> tree;
    static int[] childCount;

    static void dfs(int node, int parent) {
        int count = 0;
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                count++;
                dfs(neighbor, node);
            }
        }
        childCount[node] = count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            tree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }

            for (int i = 0; i < n - 1; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            childCount = new int[n + 1];

            dfs(1, -1);

            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                countMap.put(childCount[i], countMap.getOrDefault(childCount[i], 0) + 1);
            }

            int result = 0;
            for (int count : countMap.values()) {
                if (count > 1) {
                    result += count * (count - 1) / 2;
                }
            }
            System.out.println(result);
        }

    }
}
