/* 
 * Sort a linked list in O(n log n) time using constant space complexity.
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
public class SortList {
    // Runtime Error, to be debugged!!! 
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode minNode = head, minPrev = head, minNext = minNode.next;
        ListNode cur = head.next, curPrev = head;
        while(cur != null) {
            if(minNode.val > cur.val) {
                minNode = cur;
                minPrev = curPrev;
                minNext = cur.next;
            }
            curPrev = cur;
            cur = cur.next;
        }
        if(minNode == head)
            head = head.next;
        else 
            minPrev.next = minNext;
        minNode.next = sortList(head);
        return minNode;
    }
}
