/*
Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null && prev.next != null) {
            ListNode cur = prev.next;
            while (cur != null && cur.val == prev.next.val) {
                cur = cur.next;
            }
            if (cur == prev.next.next) {
                prev = prev.next;
            } else {
                prev.next = cur;
            }
        }
        return dummy.next;
    }

}
