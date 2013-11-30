/*
Given a linked list, reverse the nodes of a linked list k at a time and return 
its modified list.

k is a positive integer and is less than or equal to the length of the linked 
list. If the number of nodes is not a multiple of k then left-out nodes in the 
end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode headTail = dummy;
        while (true) {
            ListNode cursor = headTail;
            int i = 0;
            while (cursor != null && i < k) {
                cursor = cursor.next;
                i++;
            }
            if (cursor == null) {
                break;
            }
            ListNode tailHead = cursor.next;
            ListNode middle = headTail.next;
            headTail.next = null;

            ListNode prev = middle;
            ListNode cur= middle.next;
            while (cur != tailHead) {
                prev.next = cur.next;
                cur.next = middle;
                middle = cur;
                cur = prev.next;
            }
            headTail.next = middle;
            headTail = prev;
        }
        return dummy.next;
    }

}
