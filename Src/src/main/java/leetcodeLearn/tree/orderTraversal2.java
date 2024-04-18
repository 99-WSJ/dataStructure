package leetcodeLearn.tree;

import sun.reflect.generics.tree.Tree;

import java.sql.Array;
import java.util.*;

/**
 * @author wsj
 * @description 迭代法遍历 使用栈
 * @date 2024年04月07日 19:44
 */
public class orderTraversal2 {
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

        orderTraversal2 orderTraversal = new orderTraversal2();
        int res = orderTraversal.fib(5);
//        List<Integer> list = orderTraversal.preorder(node1);
//        List<Integer> list = orderTraversal.inorder(node1);
        List<Integer> list = orderTraversal.postorder(node1);
        for(int index: list) {
            System.out.print(index + " ");
        }
    }

    public List<Integer> preorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()) {
            TreeNode temp = st.peek();
            st.pop();
            list.add(temp.val);
            if(temp.right != null) {st.push(temp.right);}
            if(temp.left != null) {st.push(temp.left);}
        }
        return list;
    }

    public List<Integer> inorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(!st.isEmpty() || cur != null) {
            if(cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    public List<Integer> postorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()) {
            TreeNode temp = st.peek();
            st.pop();
            list.add(temp.val);
            if(temp.left != null) {st.push(temp.left);}
            if(temp.right != null) {st.push(temp.right);}
        }
        Collections.reverse(list);
        return list;
    }


    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int a =fib(N - 1);
        int b =fib(N - 2);
        return a + b;

//        return fib(N - 1) + fib(N - 2);
    }
}
