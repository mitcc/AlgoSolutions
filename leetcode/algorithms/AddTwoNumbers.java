/*
 * You are given two linked lists representing two non-negative numbers. The 
 * digits are stored in reverse 
 * order and each of their nodes contain a single digit. Add the two numbers 
 * and return it as a linked list.

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
        if (l1 == null && l2 == null) 
            return carry == 0 ? null : new ListNode(carry);
        int i = 0, j = 0;
        if(l1 != null)
            i = l1.val;
        if(l2 != null)
            j = l2.val;
        ListNode head = new ListNode((i + j + carry) % 10);
        head.next = addTwoNumbersHelper(l1 == null ? null : l1.next, 
                l2 == null ? null : l2.next, (i + j + carry) / 10);
        return head;
    }


/**************************** updated 2014.03.16 *****************************/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            cur = cur.next;
        }
        if (carry != 0)
            cur.next = new ListNode(carry);
        return dummy.next;
    }
}
