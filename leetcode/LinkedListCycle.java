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
        ListNode cur1 = head, cur2 = head;
        while(cur2 != null && cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if(cur1 == cur2) 
                return true;
        }
        return false;
    }
}
