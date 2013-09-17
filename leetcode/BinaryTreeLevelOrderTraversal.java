/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 * For example:
 * Given binary tree {3,9,20,#,#,15,7},

 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:

 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ] 
 /**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;
        ArrayList<Integer> saveNodeVal = new ArrayList<Integer>();
        LinkedList<TreeNode> curLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        curLevel.add(root);
        while(!curLevel.isEmpty()) {
            TreeNode cur = curLevel.remove();
            if(cur.left != null)
                nextLevel.add(cur.left);
            if(cur.right != null)
                nextLevel.add(cur.right);
            saveNodeVal.add(cur.val);
            if(curLevel.isEmpty()) {
                result.add(saveNodeVal);
                curLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
                saveNodeVal = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
