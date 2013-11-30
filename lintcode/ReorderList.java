/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.



Example
For example,
Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
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
public class ReorderList {

    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        while (cur2 != null && cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        cur2 = reverse(cur1.next);
        cur1.next = null;
        cur1 = head;
        while (cur2 != null) {
            ListNode tmp1 = cur1.next;
            cur1.next = cur2;
            ListNode tmp2 = cur2.next;
            cur2.next = tmp1;
            cur1 = tmp1;
            cur2 = tmp2;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            prev.next = cur.next;
            cur.next = head;
            head = cur;
            cur = prev.next;
        }
        return head;
    }

}
