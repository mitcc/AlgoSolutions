/*
 * Given a binary tree, flatten it to a linked list in-place.

 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points 
 * to the next node of a pre-order traversal.
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
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null)
            return ;
        flatten(root.left);
        flatten(root.right);
        TreeNode R = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) {
            root = root.right;
        }
        root.right = R;
    } 

/***************************** updated 2013/12/29 ****************************/

    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    public TreeNode flatten(TreeNode root, TreeNode tail) {
        if(root == null) 
            return tail;
        root.right = flatten(root.left, flatten(root.right, tail));
        root.left = null;
        return root;
    }

/*****************************************************************************/

    public void flatten(TreeNode root) {
        if(root == null)
            return ;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.right != null) 
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
            cur.left = null;
            if(!stack.isEmpty()) 
                cur.right = stack.peek();
        }
    }
}
