package structure.tree;

/**
 * @author wsj
 * @description  二叉树；前序中序后序（依据根节点的访问顺序）
 * @date 2023年12月19日 21:05
 */
public class BinaryTreeDemo {
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //默认 null
    private HeroNode right; //默认 null
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;
    }
    public HeroNode getLeft() {
        return left;
    }
    public void setLeft(HeroNode left) {
        this.left = left;
    }
    public HeroNode getRight() {
        return right;
    }
    public void setRight(HeroNode right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }
}