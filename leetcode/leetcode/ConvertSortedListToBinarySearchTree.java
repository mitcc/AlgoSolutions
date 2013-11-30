/*
Given a singly linked list where elements are sorted in ascending order, convert
it to a height balanced BST.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = prev.next;
        }
        TreeNode root = new TreeNode(prev.next.val);
        root.right = sortedListToBST(prev.next.next);
        prev.next = null;
        root.left = sortedListToBST(dummy.next);
        return root;
    }

}
