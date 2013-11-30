/*
 * Given a linked list, determine if it has a cycle in it.

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
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        for (ListNode cur = head; cur != null && cur.next != null; ) {
            cur = cur.next.next;
            head = head.next;
            if (cur == head) {
                return true;
            }
        }
        return false;
    }

}
