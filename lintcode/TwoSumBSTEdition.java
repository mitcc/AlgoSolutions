/*
Given a binary search tree and a number n, find two numbers in the tree that
sums up to n.

 Notice

Without any extra space.

Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
and a number n = 3
return [1, 2] or [2, 1]
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
public class TwoSumBSTEdition {

    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n) {
        List<Integer> list = inorderMorrisTraversal(root);
        if (list.size() < 2) {
            return null;
        }
        int[] result = new int[2];
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == n) {
                result[0] = list.get(i);
                result[1] = list.get(j);
                break;
            } else if (sum < n) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public List<Integer> inorderMorrisTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return result;
    }

}
