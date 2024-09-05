package leetcodeLearn.interview150;

import leetcodeLearn.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Src
 * @description: 判断是否是相同的树
 * @author: wsj
 * @create: 2024-09-04 11:03
 **/
public class Solution100 {
    public static void main(String[] args) {

    }

    static boolean isSame(TreeNode p, TreeNode q) {
        if(p.val != q.val && p.left != q.left && p.right != q.right) {
            return false;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(p);
        que.offer(q);
        while(!que.isEmpty()){
            int size = que.size();
            while (size > 0) {
                TreeNode temp = que.poll();
                if(temp.left != null) {
                    que.offer(temp.left);
                }
                if(temp.right != null) {
                    que.offer(temp.right);
                }
                size--;
            }

        }




        return true;
    }
}
