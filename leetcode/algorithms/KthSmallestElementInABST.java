/*
 * Given a binary search tree, write a function kthSmallest to find 
 * the kth smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 <= k <= BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and 
 * you need to find the kth smallest frequently? How would you 
 * optimize the kthSmallest routine?
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
public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        int count = k;
        while (cur != null || stack.size() > 0) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                count--;
                if (count == 0)
                    return cur.val;
                cur = cur.right;
            }
        }
        return 0;
    }

/*******************************************************************/

    private int count;
    
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        int kth = kthSmallest(root.left, k);
        if (count == k)
            return kth;
        else if (++count == k)
            return root.val;
        return kthSmallest(root.right, k);
    }

/*******************************************************************/

    public int kthSmallest(TreeNode root, int k) {
        int leftSize = treeSize(root.left);
        if (k - 1 == leftSize)
            return root.val;
        else if (k - 1 < leftSize)
            return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - leftSize - 1);
    }

    public int treeSize(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + treeSize(root.left) + treeSize(root.right);
    }

}
