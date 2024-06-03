package leetcodeLearn.hot.fifty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wsj
 * @description 104 最大深度
 * @date 2024年04月24日 21:36
 */
public class hot37 {
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

    private static int fuc(TreeNode root) {
        int deep = 0;
        if(root == null)  {
            return deep;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0){
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
                size--;
            }
            deep++;
        }
        return deep;

    }
}
