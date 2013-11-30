/*
Find the maximum node in a binary tree, return the node.

Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   3 -4  -5
return the node with value 3.
 */
public class BinaryTreeMaximumNode {

    /*
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = root;
        TreeNode leftMax = maxNode(root.left);
        TreeNode rightMax = maxNode(root.right);
        if (leftMax != null && leftMax.val > result.val) {
            result = leftMax;
        }
        if (rightMax != null && rightMax.val > result.val) {
            result = rightMax;
        }
        return result;
    }

}
