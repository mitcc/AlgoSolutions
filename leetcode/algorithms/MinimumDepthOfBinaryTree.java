/*
 * Given a binary tree, find its minimum depth.

 * The minimum depth is the number of nodes along the shortest 
 * path from the root node down to the nearest leaf node.
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
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null || root.right == null)
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

/*****************************************************************************/

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            Queue<TreeNode> nextLayer = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null)
                    return result;
                if (cur.left != null)
                    nextLayer.add(cur.left);
                if (cur.right != null)
                    nextLayer.add(cur.right);
            }
            queue = nextLayer;
        }
        return result;
    }
}
