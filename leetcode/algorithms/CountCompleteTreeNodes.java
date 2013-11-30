/*
 * Given a complete binary tree, count the number of nodes.

 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly 
 * the last, is completely filled, and all nodes in the 
 * last level are as far left as possible. It can have 
 * between 1 and 2^h nodes inclusive at the last level h.
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
        int count = 0;
        int height = getCompBinTreeHeight(root);
        while (root != null) {
            if (getCompBinTreeHeight(root.right) == height - 1) {
                count += 1 << (height - 1);
                root = root.right;
            } else {
                count += 1 << (height - 2);
                root = root.left; 
            }
            height--;
        }
        return count;
    }

    public int getCompBinTreeHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }   

/*******************************************************************/

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getCompBinTreeHeight(root.left);
        int rightHeight = getCompBinTreeHeight(root.right);
        if (leftHeight == rightHeight)
            return (1 << leftHeight) + countNodes(root.right);
        return (1 << rightHeight) + countNodes(root.left);
    }

    public int getCompBinTreeHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }   

/*******************************************************************/

    public int countNodes(TreeNode root) {
        int left = 0;
        int right = 0;
        for (TreeNode cur = root; cur != null; cur = cur.left) {
            left++;
        }
        for (TreeNode cur = root; cur != null; cur = cur.right) {
            right++;
        }
        if (left == right)
            return (1 << left) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
