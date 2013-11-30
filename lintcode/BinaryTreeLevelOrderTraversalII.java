/*
 * Given a binary tree, return the bottom-up level 
 * order traversal of its nodes' values. (ie, from 
 * left to right, level by level from leaf to root).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
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
public class BinaryTreeLevelOrderTraversalII {

    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        if (root != null) {
            curLevel.offer(root);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (curLevel.peek() != null) {
            TreeNode node = curLevel.poll();
            list.add(node.val);
            if (node.left != null) {
                nextLevel.offer(node.left);
            }
            if (node.right != null) {
                nextLevel.offer(node.right);
            }
            if (curLevel.peek() == null) {
                curLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
                result.add(0, list);
                list = new ArrayList<Integer>();
            }
        }
        return result;
    }

}
