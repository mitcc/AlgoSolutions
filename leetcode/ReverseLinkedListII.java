/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 * return 1->4->3->2->5->NULL.

 * Note:
 * Given m, n satisfy the following condition:
 * 1 ? m ? n ? length of list.
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
public class ReverseLinkedListII {
/*  public ListNode reverseBetween(ListNode head, int m, int n) {
        for(int i = 0; i <= (n - m) / 2; i++) {
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return head;
        ListNode runner = head, first = null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(n > 0) {
            if(m == 1)
                first = runner;
            if(m <= 1)
                list.add(runner.val);
            m--;
            n--;
            runner = runner.next;
        }
        for(int i = list.size() - 1; i >= 0; i--) {
            first.val = list.get(i);
            first = first.next;
        }
        return head;
    }
*/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode prev = null, current = head, next = null;
        for(int i = 0; i < m - 1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode low = prev, high = current;
        prev = current;
        current = current.next;
        for(int i = m; i < n; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if(high != null)
            high.next = current;
        if(low != null)
            low.next = prev;
        else
            head = prev;
        return head;
    }
}
