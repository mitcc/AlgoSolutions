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

import java.util.ArrayList;

public class BinaryTreeMaximumPathSum {

    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
    	maxSum(root);
    	return result;
    }

    public int maxSum(TreeNode root) {
    	if (root == null) 
    		return 0;
    	int L = maxSum(root.left);
    	int R = maxSum(root.right);
    	result = Math.max(result, root.val 
                + Math.max(Math.max(0, L + R), Math.max(L, R)));
    	return root.val + Math.max(0, Math.max(L, R));
    }
    

/*****************************************************************************/

    public int maxPathSum(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>(1);
    	result.add(Integer.MIN_VALUE);
    	maxSum(root, result);
    	return result.get(0);
    }

    public int maxSum(TreeNode root, List<Integer> result) {
    	if (root == null) 
    		return 0;
    	int L = maxSum(root.left, result);
    	int R = maxSum(root.right, result);
    	result.set(0, Math.max(result.get(0), root.val 
                    + Math.max(Math.max(0, L + R), Math.max(L, R))));
    	return root.val + Math.max(0, Math.max(L, R));
    }
    
}
