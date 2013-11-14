/*
 * Sort a linked list using insertion sort.
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
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode minNode = head, minPrev = head, minNext = head, cur = head, curPrev = head;
        while(cur != null) {
            if(cur.val < minNode.val) {
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
        minNode.next = insertionSortList(head);
        return minNode;
    }
}
