/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting
node to any node in the tree along the parent-child connections. The path must
contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] cache = {Integer.MIN_VALUE};
        maxUpDownPathSum(root, cache);
        return cache[0];
    }

    public int maxUpDownPathSum(TreeNode root, int[] cache) {
        if (root == null) {
            return 0;
        }
        int L = Math.max(0, maxUpDownPathSum(root.left, cache));
        int R = Math.max(0, maxUpDownPathSum(root.right, cache));
        cache[0] = Math.max(cache[0], root.val 
                + Math.max(Math.max(0, L + R), Math.max(L, R)));
        return root.val + Math.max(0, Math.max(L, R));
    }

/*****************************************************************************/

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxUpDownPathSum(root);
        return maxSum;
    }

    public int maxUpDownPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = Math.max(0, maxUpDownPathSum(root.left));
        int R = Math.max(0, maxUpDownPathSum(root.right));
        maxSum = Math.max(maxSum, root.val 
                + Math.max(Math.max(0, L + R), Math.max(L, R)));
        return root.val + Math.max(0, Math.max(L, R));
    }

}
