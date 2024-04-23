package leetcodeLearn.hot;

/**
 * @author wsj
 * @description 141  环形链表
 * @date 2024年04月23日 22:50
 */
public class hot25 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
//        node5.next = node3;
        System.out.println(hasCycle(head));

    }
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while(fast.next != null && fast.next.next != null) {
            if(fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;

    }

}
