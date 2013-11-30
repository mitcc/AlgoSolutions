/*
 * Given a sorted (increasing order) array, Convert it to 
 * create a binary tree with minimal height.

Example
Given [1,2,3,4,5,6,7], return

     4
   /   \
  2     6
 / \    / \
1   3  5   7
Note
There may exist multiple valid solutions, return any of them.
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
public class ConvertSortedArrayToBinarySearchTreeWithMinimalHeight {

    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        return helper(A, 0, A.length - 1);
    }

    public TreeNode helper(int[] A, int low, int high) {
        if (low > high) {
            return null;
        }
        TreeNode root = new TreeNode(A[(low + high) / 2]);
        root.left = helper(A, low, (low + high) / 2 - 1);
        root.right = helper(A, (low + high) / 2 + 1, high);
        return root;
    }

}
