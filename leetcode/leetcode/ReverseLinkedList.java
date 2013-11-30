/*
 * Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively. Could you 
implement both?
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
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            prev.next = cur.next;
            cur.next = head;
            head = cur;
            cur = prev.next;
        }
        return head;
    }

/*****************************************************************************/

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next = null;
        ListNode cur = result;
        for (; cur.next != null; cur = cur.next);
        cur.next = head;
        return result;
    }

}
