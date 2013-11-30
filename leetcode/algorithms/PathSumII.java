/*
 * Given a binary tree and a sum, find all root-to-leaf 
 * paths where each path's sum equals the given sum.

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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(result, list, root, sum);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            TreeNode root, int sum) {
        if (root == null)
            return;
        list.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) 
            result.add(new ArrayList<Integer>(list));
        dfs(result, list, root.left, sum - root.val);
        dfs(result, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }

}
