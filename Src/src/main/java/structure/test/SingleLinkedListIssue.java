package test;

public class SingleLinkedListIssue {
    //获取单链表有效节点的个数
    public static int getLength(HeroNode head) {
        if(head.next == null) {
            System.out.println("空链表");
            return  0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null)  {
            length ++;
            cur = cur.next;
        }
        return length;
    }
    // 查找倒数第k个节点
    public static HeroNode findLastIndexNode(HeroNode head, int k) {
        if (head.next == null) {
            System.out.println("空链表");
            return null;
        }
        int length = getLength(head);
        //做一个校验
        if(k <= 0 || k > length) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < length - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //单链表反转
    public static void reverseList(HeroNode head) {
        //如果为空或者只有一个元素，不需要反转
        if(head.next == null|| head.next.next == null) {
            return ;
        }
        HeroNode cur = head.next;
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode next = null;

        while(cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //从尾到头打印单链表
    //反转链表，会改变原始结构； 利用栈结构

}
