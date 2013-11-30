/*
Given an array where elements are sorted in ascending order, convert it to a 
height balanced BST.
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
public class ConvertSortedArrayToBinaryTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (nums == null || start > end) {
            return null;
        }
        int midIndex = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = helper(nums, start, midIndex - 1);
        root.right = helper(nums, midIndex + 1, end);
        return root;
    }

}
