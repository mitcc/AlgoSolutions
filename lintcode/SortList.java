/*
 * Sort a linked list in O(n log n) time using constant space complexity.

Example
Given 1-3->2->null, sort it to 1->2->3->null.
 */
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class SortList {

    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    // TODO O(1) space!!!
    // O(nlgn) time, O(lgn) space
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        while (cur2 != null && cur2.next != null) {
            cur2 = cur2.next.next;
            cur1 = cur1.next;
        }
        ListNode head2 = cur1.next;
        cur1.next = null;
        return mergeTwoList(sortList(head), sortList(head2));
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (; l1 != null && l2 != null; cur = cur.next) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

}
