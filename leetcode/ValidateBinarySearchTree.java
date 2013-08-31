/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 * Assume a BST is defined as follows:

 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.

 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies 
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
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, int min, int max) {
        if(root == null)
            return true;
        return root.val > min && root.val < max && isValidBSTHelper(root.left, min, root.val) 
            && isValidBSTHelper(root.right, root.val, max);
    }

/*  public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.left != null) {
            TreeNode p = root.left;
            if(p.val >= root.val)
                return false;
            while(p.right != null) {
                if(p.right.val >= root.val)
                    return false;
                p = p.right;
            }
        }
        if(root.right != null) {
            TreeNode p = root.right;
            if(p.val <= root.val)
                return false;
            while(p.left != null) {
                if(p.left.val <= root.val)
                    return false;
                p = p.left;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }*/
}
