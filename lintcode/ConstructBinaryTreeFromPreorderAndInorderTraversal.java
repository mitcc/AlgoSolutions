/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Example
Given in-order [1,2,3] and pre-order [2,1,3], return a tree:

  2
 / \
1   3
Note
You may assume that duplicates do not exist in the tree.
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, 
                inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pLow, int pHigh, 
            int[] inorder, int iLow, int iHigh) {
        if (pLow > pHigh || iLow > iHigh || pHigh - pLow != iHigh - iLow) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pLow]);
        int i = iLow;
        for (; i < iHigh && inorder[i] != preorder[pLow]; ++i);
        root.left = buildTree(preorder, pLow + 1, i - iLow + pLow, 
                inorder, iLow, i - 1);
        root.right = buildTree(preorder, i - iLow + 1 + pLow, pHigh, 
                inorder, i + 1, iHigh);
        return root;
    }

}
