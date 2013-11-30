/*
 * Given a linked list, remove the nth node from the end of
 * list and return its head.

 * For example,

 *    Given linked list: 1->2->3->4->5, and n = 2.

 *    After removing the second node from the end, the 
 *    [<0;80;42Mlinked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
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
        ListNode first = dummy;
        ListNode second = dummy;
        while (first.next != null) {
            first = first.next;
            if (--n < 0) {
                second = second.next;
            }
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
