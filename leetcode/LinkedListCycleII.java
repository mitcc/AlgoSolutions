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
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        int cnt = 0;
        while(head != null && !map.containsValue(head)) {
            map.put(cnt++, head);
            head = head.next;
        }
        return head;
    }
}
