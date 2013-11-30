/*
 * Given a binary tree, return the zigzag level order traversal 
 * of its nodes' values. (ie, from left to right, then right to 
 * left for the next level and alternate between).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
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
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            curLevel.offer(root);
        }
        boolean isOddLevel = false;
        while (!curLevel.isEmpty()) {
            TreeNode node = curLevel.poll();
            list.add(node.val);
            if (node.left != null) {
                nextLevel.offer(node.left);
            }
            if (node.right != null) {
                nextLevel.offer(node.right);
            }
            if (curLevel.isEmpty()) {
                if (isOddLevel) {
                    Collections.reverse(list);
                }
                result.add(list);
                list = new ArrayList<Integer>();
                curLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
                isOddLevel = !isOddLevel;
            }
        }
        return result;
    }

}
