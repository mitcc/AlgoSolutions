/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 * For example, this binary tree is symmetric:

 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:

 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.

 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path 
 * terminator where no node exists below.

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
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null && q != null || p != null && q == null)
            return false;
        if(p.val != q.val)
            return false;
        return isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);
    }
}
