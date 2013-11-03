/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        ListNode subList = head.next;
        ListNode cur1 = head, cur2 = head.next;
        while(cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        head.next = cur2;
        cur1.next = null;
        reorderList(subList);
        head = head.next;
        head.next = subList;
    }
}
