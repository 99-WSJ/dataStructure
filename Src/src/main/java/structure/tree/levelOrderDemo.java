package structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderDemo {

    // BFS--迭代方式--借助队列
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //checkFun01(root,0);
        checkFun02(root);

        return resList;
    }


    private void checkFun02(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while(!que.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int len = que.size();
            while(len > 0) {
                TreeNode temNode = que.poll();
                assert temNode != null;
                list.add(temNode.val);

                if (temNode.left != null) {que.offer(temNode.left);}
                if (temNode.right != null) {que.offer(temNode.right);}
                len--;
            }
            resList.add(list);
        }





    }
}
