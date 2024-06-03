package leetcodeLearn.hot.fifty;

/**
 * @author wsj
 * @description 2、两数相加
 * @date 2024年04月25日 21:55
 */
public class hot28 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(9);
        ListNode node4 = new ListNode(9, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode node00 = new ListNode(9);
        ListNode node03 = new ListNode(7);
        ListNode node07 = new ListNode(7);
        node00.next = node03;
        node03.next = node07;

        ListNode node = addTwoNumbers2(node00, head);
        System.out.println(node);

    }

    //    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode pre = new ListNode(0);
//        ListNode q = pre;
//        int flag = 0;
//        while(l1 != null && l2 != null) {
//            int add = l1.val + l2.val + flag;
//            q.next = new ListNode (add % 10);
//            flag = add > 9 ? 1:0;
//            l1 = l1.next;
//            l2 = l2.next;
//            q = q.next;
//        }
//        if(l1 == null) {
//            while(l2 != null) {
//                int add = flag + l2.val;
//                q.next = new ListNode (add % 10);
//                flag = add > 9 ? 1:0;
//                l2 = l2.next;
//                q = q.next;
//            }
//            if(flag == 1 ) {
//                q.next = new ListNode (1);
//            }
//            return pre.next;
//        }
//
//        while(l1 != null) {
//            int add = flag + l1.val;
//            q.next = new ListNode (add % 10);
//            flag = add > 9 ? 1:0;
//            l1 = l1.next;
//            q = q.next;
//        }
//        if(flag == 1 ) {
//            q.next = new ListNode (1);
//        }
//        return pre.next;
//    }
    static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode q = pre;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null? 0: l1.val;
            int n2 = l2 == null? 0: l2.val;
            int add = n1 + n2 + flag;
            q.next = new ListNode(add % 10);
            flag = add > 9 ? 1 : 0;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
            q = q.next;
        }
        if (flag == 1) {
            q.next = new ListNode(1);
        }
        return pre.next;
    }
}
