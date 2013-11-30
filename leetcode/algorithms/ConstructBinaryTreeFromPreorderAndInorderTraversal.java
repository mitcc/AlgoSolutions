/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 * Note:
 * You may assume that duplicates do not exist in the tree.
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
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, 
                inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd,
            int[] inorder, int iStart, int iEnd) {
        if (pEnd - pStart != iEnd - iStart || pStart > pEnd || iStart > iEnd)
            return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int i = iStart;
        while (i <= iEnd && inorder[i] != preorder[pStart]) {
            i++;
        }
        root.left = buildTree(preorder, pStart + 1, pStart - iStart + i, 
                inorder, iStart, i - 1);
        root.right = buildTree(preorder, pStart - iStart + i + 1, pEnd, 
                inorder, i + 1, iEnd);
        return root;
    } 

}
