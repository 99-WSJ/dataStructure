package leetcodeLearn.hot.fifty;

/**
 * @author wsj
 * @description 21 合并两个有序链表
 * @date 2024年04月25日 20:59
 */
public class hot27 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode node00 = new ListNode(0);
        ListNode node03 = new ListNode(3);
        ListNode node07 = new ListNode(7);
        node00.next = node03;
        node03.next = node07;

        ListNode res = mergeTwoLists(node00, head);
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val ) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2: list1;
        return prehead.next;
    }
}
