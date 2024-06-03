package leetcodeLearn.hot.fifty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsj
 * @description 142 环形链表2
 * @date 2024年04月24日 22:50
 */
public class hot26 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        node5.next = node3;
        System.out.println(detectCycle(head).val);

    }

    private static ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            if(map.containsKey(cur)) {
                return cur;
            }
            map.put(cur, cur.val);
            cur = cur.next;
        }
        return null;
    }
}
