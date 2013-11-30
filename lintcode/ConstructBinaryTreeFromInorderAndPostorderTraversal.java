/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Example
Given inorder [1,2,3] and postorder [1,3,2], return a tree:

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
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, 
                postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int iLow, int iHigh, 
            int[] postorder, int pLow, int pHigh) {
        if (iLow > iHigh || pLow > pHigh || iHigh - iLow != pHigh - pLow) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pHigh]);
        int i = iLow;
        for (; inorder[i] != postorder[pHigh]; ++i);
        root.left = buildTree(inorder, iLow, i - 1, 
                postorder, pLow, i - iLow + pLow - 1);
        root.right = buildTree(inorder, i + 1, iHigh, 
                postorder, i - iLow + pLow, pHigh - 1);
        return root;
    }

}
