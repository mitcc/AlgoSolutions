/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 * Assume a BST is defined as follows:

 * The left subtree of a node contains only nodes with keys less than the node's 
 * key.
 * The right subtree of a node contains only nodes with keys greater than the 
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 

 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' 
 * signifies 
 * a path terminator where no node exists below.

 * Here's an example:

 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}". 
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
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        return root == null || min < root.val && root.val < max && 
            isValidBST(root.left, min, root.val) && 
            isValidBST(root.right, root.val, max);
    }

/*****************************************************************************/

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            if (root.val <= root.left.val || root.val <= cur.val)
                return false;
        }
        if (root.right != null) {
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            if (root.val >= root.right.val || root.val >= cur.val)
                return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

/*****************************************************************************/
    
    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return true;
        boolean isLeftValid = true;
        boolean isRightValid = true;
        if (root.left != null) {
            TreeNode leftMaxNode = root.left;
            while (leftMaxNode.right != null) {
                leftMaxNode = leftMaxNode.right;
            }
            isLeftValid = root.val > root.left.val && 
                root.val > leftMaxNode.val && isValidBST(root.left);
        }
        if (root.right != null) {
            TreeNode rightMinNode = root.right;
            while (rightMinNode.left != null) {
                rightMinNode = rightMinNode.left;
            }
            isRightValid = root.val < root.right.val && 
                root.val < rightMinNode.val && isValidBST(root.right);
        }
        return isLeftValid && isRightValid;
    }

}
