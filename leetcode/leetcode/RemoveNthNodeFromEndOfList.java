/*
Given a linked list, remove the nth node from the end of list and return its 
head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 
   1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (ListNode cur = head; cur != null; --n, cur = cur.next) {
            if (n <= 0) {
                prev = prev.next;
            }
        }
        prev.next = prev.next.next;
        return dummy.next;
    }

}
