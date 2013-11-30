/*
Given a root of Binary Search Tree with unique value for each node. Remove the
node with given value. If there is no such a node with given value in the
binary search tree, do nothing. You should keep the tree still a binary search
tree after removal.

Example
Given binary search tree:

    5
   / \
  3   6
 / \
2   4
Remove 3, you can either return:

    5
   / \
  2   6
   \
    4
or

    5
   / \
  4   6
 /
2
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
public class RemoveNodeInBinarySearchTree {

    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (value == root.val) {
            if (root.left == null || root.right == null) {
                root = root.left != null ? root.left : root.right;
            } else {
                TreeNode right = root.right;
                TreeNode cur = root.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                cur.right = right;
                root = root.left;
            }
        } else if (value < root.val) {
            root.left = removeNode(root.left, value);
        } else {
            root.right = removeNode(root.right, value);
        }
        return root;
    }

}
