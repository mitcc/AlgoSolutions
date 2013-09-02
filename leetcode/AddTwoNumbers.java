/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse 
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8 
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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    public ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0)
            return null;
        if(l1 == null && l2 == null && carry != 0)
            return new ListNode(carry);
        int i = 0, j = 0;
        if(l1 != null)
            i = l1.val;
        if(l2 != null)
            j = l2.val;
        ListNode head = new ListNode((i + j + carry) % 10);
        head.next = addTwoNumbersHelper((l1 == null ? null : l1.next), (l2 == null ? null : l2.next), (i + j + carry) / 10);
        return head;
    }
}
