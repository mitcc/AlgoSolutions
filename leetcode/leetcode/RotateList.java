/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode cur = head;
        for (; cur.next != null; cur = cur.next, len++);
        cur.next = head;
        for (int i = 0; i < len - k % len; ++i, cur = cur.next);
        head = cur.next;
        cur.next = null;
        return head;
    }

}
