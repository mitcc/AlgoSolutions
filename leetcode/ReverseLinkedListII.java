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
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        for(int i = 0; i < (n - m) / 2; i++) {
            int curM = m + i;
            int curN = n - i;
            ListNode mNode = head;
            ListNode nNode = head;
            while(curM - 1 > 0) {
                mNode = mNode.next;
                curM--;
            }
            while(curN - 1 > 0) {
                nNode = nNode.next;
                curN--;
            }
            int temp = mNode.val;
            mNode.val = nNode.val;
            nNode.val = temp;
        }
        return head;
    }
}
