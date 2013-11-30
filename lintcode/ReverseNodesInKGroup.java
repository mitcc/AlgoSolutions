/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

Example
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesInKGroup {

    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = dummy;
        while (cur != null) {
            int i = 0;
            for (; i < k && cur != null; ++i) {
                cur = cur.next;
            }
            if (i < k || cur == null) {
                break;
            }
            ListNode last = cur.next;
            cur.next = null;
            ListNode middle = reverse(prev.next);
            cur = prev.next;
            prev.next = middle;
            prev = cur;
            prev.next = last;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = prev.next;
        while (cur != null) {
            prev.next = cur.next;
            cur.next = head;
            head = cur;
            cur = prev.next;
        }
        return head;
    }

/*********************************************************/

    public ListNode reverseKGroup(ListNode head, int k) {

    }

    public ListNode reverse(ListNode prev, ListNode next) {
        if (prev == null || prev.next == null || prev.next == next) {
            return prev;
        }
        ListNode last = prev.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = last.next;
        }
        return prev;
    }

}
