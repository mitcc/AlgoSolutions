/*
 * Given a binary tree, find its maximum depth.

 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
package info.mitcc.leetcode;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		int L = maxDepth(root.left);
		int R = maxDepth(root.right);
		return Math.max(L, R) + 1;
	}
}
