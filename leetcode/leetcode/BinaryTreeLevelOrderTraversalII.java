/*
Given a binary tree, return the bottom-up level order traversal of its nodes' 
values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
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
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        current.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        while (!current.isEmpty()) {
            TreeNode node = current.poll();
            list.add(node.val);
            if (node.left != null) {
                next.offer(node.left);
            }
            if (node.right != null) {
                next.offer(node.right);
            }
            if (current.isEmpty()) {
                result.add(list);
                list = new ArrayList<Integer>();
                current = next;
                next = new LinkedList<TreeNode>();
            }
        }
        Collections.reverse(result);
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelOrderBottom(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    public void levelOrderBottom(TreeNode root, int level, 
            List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        levelOrderBottom(root.left, level + 1, result);
        levelOrderBottom(root.right, level + 1, result);
    }

}
