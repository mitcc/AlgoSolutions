/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].

 * Note: Recursive solution is trivial, could you do it iteratively?
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
public class BinaryTreePostorderTraversal {
    public void helper(ArrayList<Integer> list, TreeNode root) {
        if(root == null)
            return;
        if(root.left != null)
            helper(list, root.left);
        if(root.right != null)
            helper(list, root.right);
        list.add(root.val);
    }

    public ArrayList<Integer> postorderTraversal_1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }

/********************************************************************/ 

    public ArrayList<Integer> postorderTraversal_2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode next =stack.peek();
            if(next.left == root || next.right == root || (next.left == null && next.right == null)) {
                stack.pop();
                res.add(next.val);
                root = next;
            }
            else {
                if(next.right != null)
                    stack.push(next.right);
                if(next.left != null)
                    stack.push(next.left);
            }
        }
        return res;
    }   
}
