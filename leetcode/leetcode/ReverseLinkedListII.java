/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 1; i <= n; ++i, cur = cur.next);
        ListNode tail = cur.next;
        cur.next = null;
        cur = dummy;
        for (int i = 1; i < m; ++i, cur = cur.next);
        ListNode middle = cur.next;
        cur.next = reverseList(middle);
        for (; cur.next != null; cur = cur.next);
        cur.next = tail;
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = head;
            head = next;
        }
        return head;
    }

}
