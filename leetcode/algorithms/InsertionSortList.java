/*
 * Sort a linked list using insertion sort.
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
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode minNode = head, minPrev = head, minNext = head, cur = head, curPrev = head;
        while(cur != null) {
            if(cur.val < minNode.val) {
                minNode = cur;
                minPrev = curPrev;
                minNext = cur.next;
            }
            curPrev = cur;
            cur = cur.next;
        }
        if(minNode == head) 
            head = head.next;
        else
            minPrev.next = minNext;
        minNode.next = insertionSortList(head);
        return minNode;
    }


    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        ListNode p = head.next, pStart = new ListNode(0), pEnd = head;
        pStart.next = head;
        while(p != null) {
            ListNode temp = pStart.next, prev = pStart;
            while(temp != p && p.val >= temp.val) {
                temp = temp.next;
                prev = prev.next;
            }
            if(temp == p)
                pEnd = p;
            else {
                pEnd.next = p.next;
                p.next = temp;
                prev.next = p;
            }
            p = pEnd.next;
        }
        head = pStart.next;
        return head;
    }
    

/**************************TLE, to be recorected!****************************/
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode res = new ListNode(0), cur = head.next;
        res.next = head;
        ListNode resEnd = res.next;
        while(cur != null) {
            ListNode cur1 = res, cur2 = res.next;
            while(cur2 != cur && cur2.val < cur.val) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            if(cur2 != cur) {
                ListNode temp = cur;
                cur1.next = temp;
                temp.next = cur2;
                resEnd.next = cur.next;
            } else {
                resEnd = resEnd.next;
            }
            cur = cur.next;
        }
        return res.next;
    }
}
