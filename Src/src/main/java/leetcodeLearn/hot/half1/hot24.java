package leetcodeLearn.hot.half1;

/**
 * @author wsj
 * @description  234 回文链表
 * @date 2024年04月23日 21:13
 */
public class hot24 {
    public static void main(String[] args) {
//        ListNode node6 = new ListNode(6);
//        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        Boolean b = isPalindrome(head);
        System.out.println(b);
    }

//    public static boolean isPalindrome(ListNode head) {
//        if (head == null) {
//            return true;
//        }
//
//        // 找到前半部分链表的尾节点并反转后半部分链表
//        ListNode firstHalfEnd = endOfFirstHalf(head);
//        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
//
//        // 判断是否回文
//        ListNode p1 = head;
//        ListNode p2 = secondHalfStart;
//        boolean result = true;
//        while (result && p2 != null) {
//            if (p1.val != p2.val) {
//                result = false;
//            }
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//
//        // 还原链表并返回结果
//        firstHalfEnd.next = reverseList(secondHalfStart);
//        return result;
//    }
//
//    private static ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode nextTemp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = nextTemp;
//        }
//        return prev;
//    }
//
//    private static ListNode endOfFirstHalf(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast.next != null && fast.next.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }


    private static Boolean isPalindrome(ListNode head) {
        ListNode m = endOfFirstHalf(head);
        ListNode n = reverse(m.next);
        while(n != null) {
            if(n.val != head.val) {
                return false;
            }
            System.out.println(true);
            n = n.next;
            head = head.next;
        }
        return true;

    }
    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static ListNode reverse(ListNode head) {
         ListNode prev = null;
         ListNode curr = head;
         while (curr != null) {
         ListNode next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
         }
         return prev;
    }
}
