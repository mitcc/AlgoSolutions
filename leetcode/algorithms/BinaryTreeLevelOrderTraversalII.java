/*
 * Given a binary tree, return the bottom-up level order traversal of its 
 * nodes' values. (ie, from left to right, level by level from leaf to root).

 * For example:
 * Given binary tree {3,9,20,#,#,15,7},

 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:

 * [
 *   [15,7]
 *   [9,20],
 *   [3],
 * ]
 * /
 /**
 * Definition for binary tree
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
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        if (root != null)
            cur.offer(root);
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            list.add(node.val);
            if (node.left != null)
                next.offer(node.left);
            if (node.right != null)
                next.offer(node.right);
            if (cur.isEmpty()) {
                result.add(list);
                list = new ArrayList<Integer>();
                cur = next;
                next = new LinkedList<TreeNode>();
            }
        }
        Collections.reverse(result);
        return result;
    }

}
