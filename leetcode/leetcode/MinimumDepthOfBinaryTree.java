/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root 
node down to the nearest leaf node.
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
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

/*****************************************************************************/

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> curLayer = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLayer = new LinkedList<TreeNode>();
        curLayer.offer(root);
        while (!curLayer.isEmpty()) {
            TreeNode node = curLayer.poll();
            if (node.left == null && node.right == null) {
                return ++result;
            }
            if (node.left != null) {
                nextLayer.offer(node.left);
            }
            if (node.right != null) {
                nextLayer.offer(node.right);
            }
            if (curLayer.isEmpty()) {
                result++;
                curLayer = nextLayer;
                nextLayer = new LinkedList<TreeNode>();
            }
        }
        return result;
    }

}
