package leetcodeLearn.hot.half1;

/**
 * @author wsj
 * @description  206 反转链表
 * @date 2024年04月23日 20:55
 */
public class hot23 {
    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node = reverse(node1);
        System.out.println(node.val);
    }

    private static ListNode reverse(ListNode head) {
        if(head == null ) return null;

        ListNode m = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = m;
            m = curr;
            curr = temp;
        }
        return m;
    }
}
