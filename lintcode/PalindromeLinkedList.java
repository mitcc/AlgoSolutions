/*
 * Implement a function to check if a linked list is a palindrome.

Example
Given 1->2->1, return true

Challenge
Could you do it in O(n) time and O(1) space?
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {

    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next, len++);
        ListNode cur = head;
        for (int i = 0; i < (len - 1) / 2; ++i, cur = cur.next);
        ListNode second = cur.next;
        cur.next = null;
        ListNode prev = second;
        cur = second.next;
        while (cur != null) {
            prev.next = cur.next;
            cur.next = second;
            second = cur;
            cur = prev.next;
        }
        while (second != null) {
            if (second.val != head.val) {
                return false;
            }
            second = second.next;
            head = head.next;
        }
        return true;
    }

}
