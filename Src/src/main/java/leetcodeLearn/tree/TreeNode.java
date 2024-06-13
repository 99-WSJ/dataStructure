package leetcodeLearn.tree;

/**
 * @program: Src
 * @description: tree structure
 * @author: wsj
 * @create: 2024-06-13 09:49
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) { this.val = val;}
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
