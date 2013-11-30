/*
 * Given a binary tree, determine if it is height-balanced.

 * For this problem, a height-balanced binary tree is defined 
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1. 
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return checkDepth(root) != -1;
    }

    public int checkDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = checkDepth(root.left);
        if (left == -1)
            return -1;
        int right = checkDepth(root.right);
        if (right == -1 || Math.abs(left - right) > 1)
            return -1;
        return 1 + Math.max(left, right);
    }

/*******************************************************************/
    
    // O(nlgn) time.
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 
            && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

}
