/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 */
public class RemoveDuplicatesFromSortedList {
/*   public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        int value = head.val;
        ListNode cursor = head.next;
        ListNode prev = head;
        while(cursor != null) {
            if(value == cursor.val) {
                prev.next = cursor.next;
                cursor = cursor.next;    
            } else {
                value = cursor.val;
                prev = prev.next;
                cursor = cursor.next;
            }
        }
        return head;
    } */

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode cursor = head.next;
        ListNode prev = head;
        while(cursor != null) {
            if(cursor.val == prev.val)
                prev.next = cursor.next;
            else
                prev = cursor;
            cursor = cursor.next;
        }
        return head;
    }
}
