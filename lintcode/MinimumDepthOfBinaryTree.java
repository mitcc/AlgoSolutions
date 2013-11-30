/*
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along 
the shortest path from the root node down to 
the nearest leaf node.

Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The minimum depth is 2.
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
public class MinimumDepthOfBinaryTree {

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

/*****************************************************************************/

    public int minDepth(TreeNode root) {
        Queue<TreeNode> curLayer = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLayer = new LinkedList<TreeNode>();
        int result = 0;
        if (root != null) {
            curLayer.offer(root);
            result++;
        }
        while (curLayer.peek() != null) {
            TreeNode node = curLayer.poll();
            if (node.left == null && node.right == null) {
                return result;
            }
            if (node.left != null) {
                nextLayer.offer(node.left);
            }
            if (node.right != null) {
                nextLayer.offer(node.right);
            }
            if (curLayer.peek() == null) {
                result++;
                curLayer = nextLayer;
                nextLayer = new LinkedList<TreeNode>();
            }
        }
        return result;
    }

}
