package leetcodeLearn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: Src
 * @description: 并查集
 * 1、查找：判断两个元素是否在同一个集合
 * 2、合并: 将另一个元素加入集合
 * @author: wsj
 * @create: 2024-10-12 15:37
 **/
public class disjointSetDemo {
    // 10个学生，
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        parent = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            parent[i] = i;
        }
        union(1, 2);
        union(2, 3);
        union(3, 4);
        union(6, 7);
        union(8, 9);
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= arr.length; i++) {
            set.add(find(i));
        }
        System.out.println(set.size());
    }

    static int[] parent;

    static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);  //路径压缩
        }
        return parent[a];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB; // 合并
        }
    }

}
