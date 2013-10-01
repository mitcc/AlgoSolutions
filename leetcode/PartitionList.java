/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before 
 * nodes greater than or equal to x.

 * You should preserve the original relative order of the nodes in each of the two partitions.

 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
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
public class PartitionList {
/*  public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ArrayList<Integer> small = new ArrayList<Integer>();
        ArrayList<Integer> large = new ArrayList<Integer>();
        ListNode cur = head;
        while(cur != null) {
            if(cur.val < x)
                small.add(cur.val);
            else 
                large.add(cur.val);
            cur = cur.next;
        }
        cur = head;
        int i = 0, j = 0;
        while(cur != null) {
            if(i < small.size()) {
                cur.val = small.get(i);
                i++;
            } else {
                cur.val = large.get(j);
                j++;
            }
            cur = cur.next;
        }
        return head;
    } */

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode sCur = small, lCur = large;
        while(head != null) {
            if(head.val < x) {
                sCur.next = head;
                sCur = sCur.next;
            } else {
                lCur.next = head;
                lCur = lCur.next;
            }
            head = head.next;
        }
        sCur.next = large.next;
        lCur.next = null;
        return small.next;
    }
}
