/*
 * Given a binary tree, return the level order traversal of 
 * its nodes' values. (ie, from left to right, level by level).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Challenge
Challenge 1: Using only 1 queue to implement it.

Challenge 2: Use DFS algorithm to do it.
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
public class BinaryTreeLevelOrderTraversal {

    // Using only 1 queue
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int curLevel = 1;
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            curLevel--;
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (curLevel == 0) {
                result.add(list);
                list = new ArrayList<Integer>();
                curLevel = queue.size();
            }
        }
        return result;
    }

/*******************************************************************/

    // Using DFS
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        dfs(result, root, 0);
        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> result, 
            TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        dfs(result, root.left, level + 1);
        dfs(result, root.right, level + 1);
    }

/*******************************************************************/

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            curLevel.offer(root);
        }
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
                result.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return result;
    }

}
