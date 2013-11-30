/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric 
around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
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
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftChild = queue.poll();
            TreeNode rightChild = queue.poll();
            if (leftChild == null && rightChild == null) {
                continue;
            }
            if (leftChild == null && rightChild != null 
                    || leftChild != null && rightChild == null 
                    || leftChild.val != rightChild.val) {
                return false;
            }
            queue.offer(leftChild.left);
            queue.offer(rightChild.right);
            queue.offer(leftChild.right);
            queue.offer(rightChild.left);
        }
        return true;
    }

/*****************************************************************************/

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null || left != null && right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) 
            && isSymmetric(left.right, right.left);
    }

}
