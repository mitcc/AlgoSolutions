/*
 * Write a program to find the node at which the intersection of
 * two singly linked lists begins.

Example
The following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Note
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the 
function returns.
You may assume there are no cycles anywhere in the entire linked 
structure.
Challenge
Your code should preferably run in O(n) time and use only O(1) 
memory.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) 
            return null;
        ListNode fast = headA;
        while (fast.next != null) {
            fast = fast.next;
        }
        fast.next = headB;
        fast = headA.next.next;
        ListNode slow = headA.next;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = headA;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
