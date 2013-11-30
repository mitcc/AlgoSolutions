/*
 * Given a singly linked list where elements are sorted in 
 * ascending order, convert it to a height balanced BST.

Example
               2
1->2->3  =>   / \
             1   3
 */
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class ConvertSortedListToBalancedBST {

    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode cur1 = head;
        ListNode cur2 = head.next.next;
        while (cur2 != null && cur2.next != null) {
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
