/*
 * Given n, generate all structurally unique BST's 
 * (binary search trees) that store values 1...n.

Example
Given n = 3, your program should return all 5 unique 
BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
public class UniqueBinarySearchTreesII {

    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public List<TreeNode> generate(int low, int high) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (low > high) {
            result.add(null);
        }
        for (int i = low; i <= high; ++i) {
            for (TreeNode left : generate(low, i - 1)) {
                for (TreeNode right : generate(i + 1, high)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }

}
