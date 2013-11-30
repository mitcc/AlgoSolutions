/*
Given a singly linked list, group all odd nodes together followed by the even
nodes. Please note here we are talking about the node number and not the value
in the nodes.

You should try to do it in place. The program should run in O(1) space
complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was
in the input.
The first node is considered odd, the second node even and so on ...
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        for (ListNode oddEnd = head, cur = head.next; cur != null 
                && cur.next != null; oddEnd = oddEnd.next, cur = cur.next) {
            ListNode tmp = cur.next.next;
            cur.next.next = oddEnd.next;
            oddEnd.next = cur.next;
            cur.next = tmp;
        }
        return head;
    }

/*****************************************************************************/

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHalf = head.next;
        ListNode cur1 = head;
        ListNode cur2 = evenHalf;
        while (cur1 != null && cur1.next != null 
                && cur2 != null && cur2.next != null) {
            if (cur2 != null && cur2.next != null) {
                cur1.next = cur2.next;
                cur1 = cur1.next;
            }
            if (cur1 != null && cur1.next != null) {
                cur2.next = cur1.next;
                cur2 = cur2.next;
            }
        }
        cur2.next = null;
        cur1.next = evenHalf;
        return head;
    }

}
