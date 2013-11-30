/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return 
 * its modified list.

 * If the number of nodes is not a multiple of k then left-out nodes in the end 
 * should remain as it is.

 * You may not alter the values in the nodes, only nodes itself may be changed.

 * Only constant memory is allowed.

 * For example,
 * Given this linked list: 1->2->3->4->5

 * For k = 2, you should return: 2->1->4->3->5

 * For k = 3, you should return: 3->2->1->4->5
 * 
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        for(int i = 1; i < k; i++) {
            if(cur.next != null)
                cur = cur.next;
            else
                return head;
        }
        ListNode toBeProcess = cur.next;
        cur.next = null;
        head = reverse(head);
        cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = reverseKGroup(toBeProcess, k);
        return head;
    }


    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head.next;
        head.next = null;
        while(p != null) {
            ListNode q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        return head;
    }
}
