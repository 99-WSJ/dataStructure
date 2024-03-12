package test.test2;

/**
 * @author wsj
 * @description
 * @date 2024年01月14日 12:53
 */
public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(6);
        ListNode node1 = new ListNode(5, node);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(6, node3);
        ListNode node5 = new ListNode(2, node4);
        ListNode node6 = new ListNode(1, node5);
        System.out.println(node);
        Solution solution = new Solution();
        ListNode result = solution.reverseList(node6);
//        ListNode result = solution.removeElements(node6, 6);
        System.out.println(result);

    }
    public ListNode removeElements(ListNode head, int val) {
        // [1,2,6,3,4,5,6]
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while(head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null)
            return head;
        ListNode prev=head;
        //确保当前结点后还有结点
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return head;

    }

    public ListNode reverseList(ListNode head) {
        // [1,2,6,3,4,5,6]
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

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
    public ListNode() {}
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
