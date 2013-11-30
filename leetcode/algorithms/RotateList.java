/*
 * Given a list, rotate the list to the right 
 * by k places, where k is non-negative.

 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
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
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return head;
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        cur.next = head;
        for (int i = 0; i < len - n % len; i++, cur = cur.next);
        head = cur.next;
        cur.next = null;
        return head;
    }

}
