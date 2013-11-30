/*
 * Given an array where elements are sorted in ascending order, convert it to a 
 * height balanced BST.
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
public class ConvertSortedArrayToBinarySearchTree {
    
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBSTHelper(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBSTHelper(num, start, mid - 1);
        root.right = sortedArrayToBSTHelper(num, mid + 1, end);
        return root;
    }

}
