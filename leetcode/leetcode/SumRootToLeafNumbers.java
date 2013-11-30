/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path 
could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> valueStack = new Stack<Integer>();
        nodeStack.push(root);
        valueStack.push(root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int value = valueStack.pop();
            if (node.left == null && node.right == null) {
                result += value;
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                valueStack.push(10 * value + node.left.val);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                valueStack.push(10 * value + node.right.val);
            }
        }
        return result;
    }

/*****************************************************************************/

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 10 * sum + root.val;
        }
        return sumNumbers(root.left, 10 * sum + root.val) 
            + sumNumbers(root.right, 10 * sum + root.val);
    }

}
