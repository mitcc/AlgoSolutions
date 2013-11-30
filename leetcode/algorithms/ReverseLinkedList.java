/*
 * Reverse a singly linked list.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur = pre.next;
        }
        return head;
    }

/*********************************************************/

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = reverseList(head.next);
        head.next = null;
        ListNode last = result;
        for (; last.next != null; last = last.next);
        last.next = head;
        return result;
    }

}
