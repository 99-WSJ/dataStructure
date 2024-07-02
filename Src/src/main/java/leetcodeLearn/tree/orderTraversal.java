package leetcodeLearn.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsj
 * @description
 * @date 2024年04月07日 19:11
 */
public class orderTraversal {
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

        orderTraversal orderTraversal = new orderTraversal();
        List<Integer> list = orderTraversal.postorderTraversal(node1);
        for(int index: list) {
            System.out.print(index + " ");
        }
    }
    //前序dfs  根 --> 左 --> 右
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    private void preorder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    // 中序dfs   左 --> 根 --> 右
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // 后序dfs  左 --> 右 --> 根
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    private void postorder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

}


