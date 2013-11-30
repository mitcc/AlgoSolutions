/*
 * Given n, generate all structurally unique BST's (binary search trees) 
 * that store values 1...n.

 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.

 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3 
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end)
            result.add(null);
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftChildren = generate(start, i - 1);
            List<TreeNode> rightChildren = generate(i + 1, end);
            for (TreeNode leftChild : leftChildren) {
                for (TreeNode rightChild : rightChildren) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    result.add(root);        
                }
            }
        }
        return result;
    }

}
