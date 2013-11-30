/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely
filled, and all nodes in the last level are as far left as possible. It can
have between 1 and 2h nodes inclusive at the last level h.
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
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        int height = completeTreeHeight(root);
        while (root != null) {
            if (completeTreeHeight(root.right) == height - 1) {
                count += 1 << (height - 1);
                root = root.right;
            } else {
                count += 1 << (height - 2);
                root = root.left;
            }
            --height;
        }
        return count;
    }

    public int completeTreeHeight(TreeNode root) {
        int height = 0;
        for (TreeNode cur = root; cur != null; height++, cur = cur.left);
        return height;
    }

/*****************************************************************************/

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = completeTreeHeight(root.left);
        int rightHeight = completeTreeHeight(root.right);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        }
        return (1 << rightHeight) + countNodes(root.left);
    }

    public int completeTreeHeight(TreeNode root) {
        int height = 0;
        for (TreeNode cur = root; cur != null; height++, cur = cur.left);
        return height;
    }

/*****************************************************************************/

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        for (TreeNode cur = root; cur != null; left++, cur = cur.left);
        for (TreeNode cur = root; cur != null; right++, cur = cur.right);
        if (left == right) {
            return (1 << left) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
