/*
Given a binary tree, imagine yourself standing on the right side of it, return
the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

/*****************************************************************************/

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> curLayer = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLayer = new LinkedList<TreeNode>();
        curLayer.offer(root);
        while (!curLayer.isEmpty()) {
            TreeNode node = curLayer.poll();
            if (node.left != null) {
                nextLayer.offer(node.left);
            }
            if (node.right != null) {
                nextLayer.offer(node.right);
            }
            if (curLayer.isEmpty()) {
                result.add(node.val);
                curLayer = nextLayer;
                nextLayer = new LinkedList<TreeNode>();
            }
        }
        return result;
    }

/*****************************************************************************/

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, result, 0);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(root.val);
        }
        dfs(root.right, result, depth + 1);
        dfs(root.left, result, depth + 1);
    }

}
