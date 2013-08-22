/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 * An example is the root-to-leaf path 1->2->3 which represents the number 123.

 * Find the total sum of all root-to-leaf numbers.

 * For example,

 *    1
 *   / \
 *  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.

 * Return the sum = 12 + 13 = 25.
 */
package info.mitcc.leetcode;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}	
}

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode root, int prev) {
		if(root == null)
			return 0;
		int result = 10 * prev + root.val;
		if(root.left == null && root.right == null)
			return result;
		else
			return sum(root.left, result) + sum(root.right, result);
	}
}
