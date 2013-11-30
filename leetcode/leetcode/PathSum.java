/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

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
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> sumStack = new Stack<Integer>();
        nodeStack.push(root);
        sumStack.push(root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int nodeSum = sumStack.pop();
            if (node.left == null && node.right == null && nodeSum == sum) {
                return true;
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                sumStack.push(nodeSum + node.left.val);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                sumStack.push(nodeSum + node.right.val);
            }
        }
        return false;
    }

/*****************************************************************************/

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) 
            || hasPathSum(root.right, sum - root.val);
    }

}
