/*
 * You have two numbers represented by a linked list, where each node 
 * contains a single digit. The digits are stored in reverse order, 
 * such that the 1's digit is at the head of the list. Write a 
 * function that adds the two numbers and returns the sum as a linked 
 * list.

Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.
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

    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carrier = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            cur.next = new ListNode((v1 + v2 + carrier) % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carrier = (v1 + v2 + carrier) / 10;
        }
        if (carrier != 0) {
            cur.next = new ListNode(carrier);
        }
        return dummy.next;
    }

}
