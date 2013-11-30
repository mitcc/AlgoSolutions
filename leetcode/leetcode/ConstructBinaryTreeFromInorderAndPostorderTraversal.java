/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

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
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, 
                postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int iStart, int iEnd, 
            int[] postorder, int pStart, int pEnd) {
        if (inorder == null || iStart < 0 || iEnd >= inorder.length 
                || iStart > iEnd || postorder == null || pStart < 0 
                || pEnd >= postorder.length || pStart > pEnd 
                || iEnd - iStart != pEnd - pStart) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        int i = pStart;
        for (; i <= iEnd && inorder[i] != postorder[pEnd]; ++i);
        root.left = buildTree(inorder, iStart, i - 1, 
                postorder, pStart, i - 1 - iStart + pStart);
        root.right = buildTree(inorder, i + 1, iEnd, 
                postorder, i - iStart + pStart, pEnd - 1);
        return root;
    }

}
