/*
 * Given a linked list, swap every two 
 * adjacent nodes and return its head.

Example
Given 1->2->3->4, you should return the 
list as 2->1->4->3.

Challenge
Your algorithm should use only constant 
space. You may not modify the values in 
the list, only nodes itself can be 
changed.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {

    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

/***********************************************/

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        head.next = swapPairs(result.next);
        result.next = head;
        return result;
    }

}
