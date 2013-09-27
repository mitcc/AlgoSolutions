/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

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
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        TreeNode root = new TreeNode(postorder[pEnd]); 
        int i = 0;
        while(inorder[iEnd - i] != postorder[pEnd]) {
            i++;
        }
        if(i != 0)
            root.right = buildTreeHelper(inorder, iEnd - i + 1, iEnd, postorder, pEnd - i, pEnd - 1);
        if(iEnd - i - 1 >= iStart)
            root.left = buildTreeHelper(inorder, iStart, iEnd - i - 1, postorder, pStart, pEnd - i - 1);
        return root;
    }
}
