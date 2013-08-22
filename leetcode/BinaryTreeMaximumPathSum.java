/*
 * Given a binary tree, find the maximum path sum.

 * The path may start and end at any node in the tree.

 * For example:
 * Given the below binary tree,

 *       1
 *      / \
 *     2   3
 * Return 6.
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
package info.mitcc.leetcode;

import java.util.ArrayList;

public class BinaryTreeMaximumPathSum {
	int max;
	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		maxSum(root);
		return max;
	}
	public int maxSum(TreeNode root) {
		if(root == null)
			return 0;
		int L = maxSum(root.left);
		int R = maxSum(root.right);
		int subMax = Math.max(Math.max(root.val, L + R + root.val), root.val + Math.max(L, R));
		max = Math.max(max, subMax);
		return Math.max(root.val, root.val + Math.max(L, R));
	}
	
	/*public int maxPathSum(TreeNode root) {
		//pass the curmax in an array that contains only one value
		ArrayList<Integer> curMax = new ArrayList<Integer>(1);
		curMax.add(Integer.MIN_VALUE);
		maxSubPath(root, curMax);
		return curMax.get(0);
	}
	
	private int maxSubPath(TreeNode root, ArrayList<Integer> curMax) {
		if(root == null)
			return 0;
		int leftMax = Math.max(0, maxSubPath(root.left, curMax));
		int rightMax = Math.max(0, maxSubPath(root.right, curMax));
		curMax.set(0, Math.max(curMax.get(0), root.val + leftMax + rightMax));
		return Math.max(root.val + leftMax, root.val + rightMax);
	}*/
}