package structure.tree;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversalDemo {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;

    }

    private void preorder(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        preorder(root.left, res);
        res.add(root.val);
        preorder(root.right, res);
    }

}

