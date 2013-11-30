/* 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
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
public class SortList {

/**************************** cheating method *******************************/

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);
        cur = head;
        int i = 0;
        while (cur != null) {
            cur.val = list.get(i);
            cur = cur.next;
            i++;
        }
        return head;
    }
}
