package leetcodeLearn.tree;

import java.util.*;

/**
 * @author wsj
 * @description  层序遍历 利用队列先进先出 / 递归
 * @date 2024年04月07日 21:18
 */
public class levelOrderTraversal {
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

        levelOrderTraversal orderTraversal = new levelOrderTraversal();
        List<List<Integer>> list = orderTraversal.levelOrder(node1);
//        List<List<Integer>> list = orderTraversal.levelOrder2(node1);
        System.out.println(list);
    }

     public List<List<Integer>> levelOrder(TreeNode root) {
         if(root == null) {
             return res;
         }

         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()) {
             List<Integer> list = new ArrayList<>();
             int len = queue.size();
             while(len > 0) {
                 TreeNode temp = queue.poll();
                 list.add(temp.val);
                 if(temp.left != null)   {queue.offer(temp.left);}
                 if(temp.right != null)   {queue.offer(temp.right);}
                 len--;

             }
             res.add(list);
         }
         return res;
     }



     public List<List<Integer>> levelOrder2(TreeNode root) {
        checkFun01(root,0);
        return res;
    }
     public void checkFun01(TreeNode root, int deep) {
        if(root == null) {
            return;
        }
        deep++;
        if(res.size() < deep) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(deep-1).add(root.val);
        checkFun01(root.left, deep);
        checkFun01(root.right, deep);

    }


}
