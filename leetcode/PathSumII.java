/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return

 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
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
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathSumHelper(root, sum, result, path);
        return result;
    }

    public void pathSumHelper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if(root == null)
            return ;
        if(root.left == null && root.right == null && root.val == sum) {
            ArrayList<Integer> temp = new ArrayList<Integer>(path);
            temp.add(root.val);
            result.add(temp);
        }
        if(root.left != null || root.right != null) {
            path.add(root.val);
            pathSumHelper(root.left, sum - root.val, result, path);
            pathSumHelper(root.right, sum - root.val, result, path);
            path.remove(path.size() - 1);
        }
    }
}
