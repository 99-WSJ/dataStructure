package leetcodeLearn.hot.fifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wsj
 * @description  94、二叉树的中序遍历
 * @date 2024年04月24日 21:06
 */
public class hot36 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(fuc(root));
    }
    public static List<Integer> fuc(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(node == null) {
            return list;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = node;
        while(!st.isEmpty() || curr != null) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                list.add(curr.val);
                curr = curr.right;

            }
        }
        return list;

    }
}

 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;this.left = left;
         this.right = right;}
}
