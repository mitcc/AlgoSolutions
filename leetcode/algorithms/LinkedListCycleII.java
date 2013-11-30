/*
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.

 * Follow up:
 * Can you solve it without using extra space?
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycleII {
/**************************** updated 20141015 *******************************/

    public ListNode findIntersection(ListNode head) {
        ListNode cur1 = head;
        ListNode cur2 = head;
        while (cur2 != null && cur2.next != null) {
            cur1 = cur1.next; 
            cur2 = cur2.next.next;
            if (cur1 == cur2)
                return cur1;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode cur1 = head;
        ListNode cur2 = findIntersection(head);
        while (cur2 != null && cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2;
    }
}
