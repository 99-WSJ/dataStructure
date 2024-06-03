package leetcodeLearn.hot.fifty;

/**
 * @author wsj
 * @description 19、删除链表的倒数第 n 个结点
 * @date 2024年04月25日 22:45
 */
public class hot29 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(9);
        ListNode node4 = new ListNode(9, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode node = fuc(head, 3);
        System.out.println(node);
    }

    private static ListNode fuc(ListNode head, int n) {
        ListNode p = reverse(head);
        ListNode q = p;
        if(n == 1) {
            return reverse(p.next);
        }
//        if(n == 2) {
//            q.next = q.next.next;
//            return reverse(p);
//        }
//        while(n > 2) {
//            q = q.next;
//            n--;
//        }
        for (int i = 2; i < n; i++) {
            q = q.next;
        }
        q.next = q.next.next;
        return reverse(p);
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
