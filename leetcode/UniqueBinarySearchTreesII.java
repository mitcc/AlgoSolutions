/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

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
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateHelper(1, n);
    }
        
    public ArrayList<TreeNode> generateHelper(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        if(start > end) 
            list.add(null);
        for(int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = generateHelper(start, i - 1);
            ArrayList<TreeNode> right = generateHelper(i + 1, end);
            for(int j = 0; j < left.size(); j++) {
                for(int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    list.add(root);
                }
            }
        }
        return list;
    }
}
