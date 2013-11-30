/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a 
binary tree in which the depth of the two subtrees of every node
never differ by more than 1.

Example
Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.
 */
public class BalancedBinaryTree {

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
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
