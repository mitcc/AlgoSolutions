/*
 * Given a list, rotate the list to the right by k 
 * places, where k is non-negative.

Example
Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
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

    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            if (--k < 0) {
                second = second.next;
            }
        }
        first.next = head;
        head = second.next;
        second.next = null;
        return head;
    }

}
