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
        if(preorder.length == 0)
            return null;
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) { 
        int i = 0;
        TreeNode root = new TreeNode(preorder[pStart]);
        while(inorder[iStart + i] != preorder[pStart]) {
            i++;
        }
        if(i != 0) 
            root.left = buildTreeHelper(preorder, pStart + 1, pStart + i, inorder, iStart, iStart + i - 1);
        if(pStart + i + 1 <= pEnd) 
            root.right = buildTreeHelper(preorder, pStart + i + 1, pEnd, inorder, iStart + i + 1, iEnd);
        return root;
    }
}
