/*
 * Given a linked list, remove the nth node from the end of list and return its head.

 * For example,

 *    Given linked list: 1->2->3->4->5, and n = 2.

 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode cur = temp.next;
        int len = 1;
        while(cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur = temp;
        for(int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return temp.next;
    }

/*  public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode cur = temp;
        while(n > 0) {
            head = head.next;
            n--;
        }
        while(head != null) {
            head = head.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return temp.next;
    }*/
}
