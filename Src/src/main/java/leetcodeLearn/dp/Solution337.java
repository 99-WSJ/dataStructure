package leetcodeLearn.dp;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import leetcodeLearn.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Queue;

/**
 * @program: Src
 * @description: 337、打家劫舍Ⅲ
 * 树形dp入门
 * @author: wsj
 * @create: 2024-06-13 09:30
 **/
public class Solution337 {
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(rob3(node1));


    }
    public static int rob3(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    static int[] robAction1(TreeNode root) {
        int res[] = new int[2];
        if (root == null)
            return res;

        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

}

