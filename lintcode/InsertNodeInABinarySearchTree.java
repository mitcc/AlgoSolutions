/*
 * Given a binary search tree and a new tree node, insert the node into the 
 * tree. You should keep the tree still be a valid binary search tree.

Have you met this question in a real interview? Yes
Example
Given binary search tree as follow, after Insert node 6, the tree should be:

  2             2
 / \           / \
1   4   -->   1   4
   /             / \ 
  3             3   6
Challenge
Can you do it without recursion?
 */
/**
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
public class InsertNodeInABinarySearchTree {

    // iteration
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null)
            return node;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < node.val) {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = node;
                    break;
                }
            } else {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = node;
                    break;
                }
            }
        }
        return root;
    }

/*******************************************************************/

    // recursion
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null)
            return node;
        if (root.val < node.val) {
            root.right = insertNode(root.right, node);
        } else {
            root.left = insertNode(root.left, node);
        }
        return root;
    }

}
