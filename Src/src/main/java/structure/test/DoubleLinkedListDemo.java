package test;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        doubleHeroNode hero1 = new doubleHeroNode(1, "宋江", "及时雨");
        doubleHeroNode hero2 = new doubleHeroNode(2, "卢俊义", "玉麒麟");
        doubleHeroNode hero3 = new doubleHeroNode(3, "吴用", "智多星");
        doubleHeroNode hero4 = new doubleHeroNode(4, "林冲", "豹子头");

        //创建要给链表
        doubleSigleLinkedList doublesingleLinkedList = new doubleSigleLinkedList();

        //加入
        doublesingleLinkedList.add(hero1);
        doublesingleLinkedList.add(hero4);
        doublesingleLinkedList.add(hero2);
        doublesingleLinkedList.add(hero3);
        // 按no插入
//        doublesingleLinkedList.addByOrder(hero1);
//        doublesingleLinkedList.addByOrder(hero3);
//        doublesingleLinkedList.addByOrder(hero2);
//        doublesingleLinkedList.addByOrder(hero4);
        doublesingleLinkedList.list();

        //根据no修改
        doubleHeroNode node = new doubleHeroNode(2, "小卢", "玉麒麟");
        doublesingleLinkedList.updata(node);
        System.out.println("修改后的链表情况");
        doublesingleLinkedList.list();


        doublesingleLinkedList.del(1);
        System.out.println("删除后的链表情况");
        doublesingleLinkedList.list();
        doublesingleLinkedList.del(3);
        doublesingleLinkedList.del(4);
        doublesingleLinkedList.del(2);
    }
    
}

class doubleSigleLinkedList {
    private doubleHeroNode head = new doubleHeroNode(0,"","");

    public void addByOrder(doubleHeroNode hero1) {
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        doubleHeroNode temp  = head.next;
        while(temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //双向链表，和单链表不同，可以直接找到删除的节点，直接删除
    public void del(int no) {
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        doubleHeroNode temp = this.head.next;


        while(true) {
            if (temp == null) {
                break;
            }
            if(temp.no == no) {
                flag = true;
                break;

            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }


//            temp.next = temp.next.next;   //单链表
        }else {
            System.out.printf("没有找到编号为%d的节点", no);
        }
    }

    /**
     节点内容更新和单链表相同
     *
     */
    public void updata(doubleHeroNode node) {
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //为什么是head.next,不是head；考虑最后一个节点updata
        //先if(temp.no == node.no)，可以不用head.next
//		HeroNode temp = this.head.next;
        doubleHeroNode temp = this.head;


        while(true) {
            if(temp.no == node.no) {
                flag = true;
                break;

            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        }else {
            System.out.printf("没有找到编号为%d的节点", node.no);
        }
    }

    public void add(doubleHeroNode hero1) {
        doubleHeroNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = hero1;
        hero1.pre = temp;  // 双向链表，考虑前后
    }

    public doubleHeroNode getHead() {
        return this.head;
    }
}

/**
 * 定义doubleHeroNode ， 每个doubleHeroNode 对象就是一个节点
 */
class doubleHeroNode {
    public int no;
    public String name;
    public String nickname;
    public doubleHeroNode next; //指向下一个节点
    public doubleHeroNode pre; //指向上一个节点
    /**
     * 构造器
     */
    public doubleHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    /**
     * 为了显示方法，我们重新toString
     */
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}
