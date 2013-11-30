/*
 * Given a sorted linked list, delete all nodes that have 
 * duplicate numbers, leaving only distinct numbers from 
 * the original list.

Example
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesFromSortedListII {

    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            if (head != null && prev.next.val == head.val) {
                head = head.next;
            } else if (prev.next.next == head) {
                prev = prev.next;
            } else {
                prev.next = head;
            }
        }
        return dummy.next;
    }

}
