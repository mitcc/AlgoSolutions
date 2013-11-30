/*
 * Merge k sorted linked lists and return it as one 
 * sorted list. Analyze and describe its complexity.
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
public class MergeKSortLists {

    public ListNode mergeKList(List<ListNode> lists) {
        if (lists.size() == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), 
                new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = (ListNode) pq.poll();
            if (node.next != null)
                pq.add(node.next);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

/*****************************************************************************/

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)
            return null; 
        int last = lists.size() - 1;
        while(last > 0) {
            int cur = 0;
            while(cur < last) {
                lists.set(cur, mergeTwoLists(lists.get(cur++), 
                            lists.get(last--)));
            }
        }
        return lists.get(0);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
