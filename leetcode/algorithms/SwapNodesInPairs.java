/*
 * Given a linked list, swap every two adjacent nodes and return its head.

 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.

 * Your algorithm should use only constant space. You may not modify the 
 * values in the list, only nodes itself can be changed.
 */
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SwapNodesInPairs {
/*************************** updated 2013/12/20 ******************************/

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = head.next;
        head.next = swapPairs(result.next);
        result.next = head;
        return result;
    } 

/*****************************************************************************/
    
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = prev.next;
        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            if (cur.next != null) {
                prev = cur;
                cur = prev.next;
            }
        }
        return dummy.next;
    } 
}
