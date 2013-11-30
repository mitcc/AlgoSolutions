/* Write a program to find the node at which the intersection of two singly 
 * linked lists begins.

 * For example, the following two linked lists:

 * A:            a1 ¡ú a2
 *                       ¨K
 *                         c1 ¡ú c2 ¡ú c3
 *                       ¨J            
 * B:     b1 ¡ú b2 ¡ú b3
 * begin to intersect at node c1.

 * Notes:

 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function 
 * returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
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

public class IntersectionOfTwoLinkedLists {

    public ListNode findIntersection(ListNode head) {
        ListNode cur1 = head;
        ListNode cur2 = head;
        while (cur2 != null && cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if (cur1 == cur2)
                return cur1;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        while (cur1 != null && cur1.next != null) {
            cur1 = cur1.next;
        }
        if (cur1 == null)
            return null;
        cur1.next = headA;
        ListNode cur2 = headB;
        ListNode cur3 = findIntersection(headB);
        while (cur3 != null && cur2 != cur3) {
            cur2 = cur2.next;
            cur3 = cur3.next;
        }
        cur1.next = null;
        return cur3;
    }
    
}
