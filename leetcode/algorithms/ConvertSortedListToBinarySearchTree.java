public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return sortedListToBSTHelper(head, 0, len - 1);
    }

    public TreeNode sortedListToBSTHelper(ListNode head, int start, int end) {
        if(start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBSTHelper(head, start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        if(head.next != null) {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        root.right = sortedListToBSTHelper(head, mid + 1, end);
        return root;
    }
/***************************** updated 2014.01.10 ****************************/

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode cur1 = head;
        ListNode cur2 = head;
        while(cur2.next.next != null && cur2.next.next.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        TreeNode root = new TreeNode(cur1.next.val);
        root.right = sortedListToBST(cur1.next.next);
        cur1.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
