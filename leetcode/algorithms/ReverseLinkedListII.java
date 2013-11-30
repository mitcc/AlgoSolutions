/*
 * Reverse a linked list from position m to n. 
 * Do it in-place and in one-pass.

 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 * return 1->4->3->2->5->NULL.

 * Note:
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
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
public class ReverseLinkedListII {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode middle;
        ListNode tail;
        for (; cur.next != null && n > 0; cur = cur.next, n--);
        tail = cur.next;
        cur.next = null;
        cur = dummy;
        for (; cur.next != null && m > 1; cur = cur.next, m--);
        middle = cur.next;
        cur.next = null;
        cur.next = reverse(middle);
        for (; cur.next != null; cur = cur.next);
        cur.next = tail;
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur = pre.next;
        }
        return head;
    }

/*******************************************************************/

    public ListNode reverseBetween(ListNode head, int m, int n) {
        for (int i = 0; i <= (n - m) / 2; i++) {
            int curM = m + i;
            int curN = n - i;
            ListNode nodeM = head;
            ListNode nodeN = head;
            for (; curM > 1; nodeM = nodeM.next, curM--);
            for (; curN > 1; nodeN = nodeN.next, curN--);
            int tmp = nodeM.val;
            nodeM.val = nodeN.val;
            nodeN.val = tmp;
        }
        return head;
    }

}
