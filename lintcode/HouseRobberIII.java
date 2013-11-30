/*
 * The thief has found himself a new place for his thievery again. There is 
 * only one entrance to this area, called the "root." Besides the root, each 
 * house has one and only one parent house. After a tour, the smart thief 
 * realized that "all houses in this place forms a binary tree". It will 
 * automatically contact the police if two directly-linked houses were broken 
 * into on the same night.

Determine the maximum amount of money the thief can rob tonight without 
alerting the police.

Example
  3
 / \
2   3
 \   \ 
  3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

    3
   / \
  4   5
 / \   \ 
1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class HouseRobberIII {

    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        return rob(root)[1];
    }

    public int[] rob(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = rob(root.left);
        int[] right = rob(root.right);
        result[0] = left[1] + right[1];
        result[1] = Math.max(root.val + left[0] + right[0], result[0]);
        return result;
    }

/*****************************************************************************/

    public int houseRobber3(TreeNode root) {
        return rob(root, new HashMap<TreeNode, Integer>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int result = root.val;
        if (root.left != null) {
            result += rob(root.left.left, map) + rob(root.left.right, map);
        }
        if (root.right != null) {
            result += rob(root.right.left, map) + rob(root.right.right, map);
        }
        result = Math.max(result, rob(root.left, map) + rob(root.right, map));
        map.put(root, result);
        return result;
    }

}
