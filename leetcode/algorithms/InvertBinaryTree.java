/*
 * Invert a binary tree.
 * 
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
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
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tmp);
        }
        return root;
    }

/*********************************************************/

    public TreeNode invertTree(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                cur = node.left;
            }
        }
        return root;
    }

/*********************************************************/

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return root;
    }

/*********************************************************/

    // Morris post-order traversal
    // O(1) space.
    public TreeNode invertTree(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode p = dummy;
        while (p != null) {
            TreeNode q = p.left;
            if (q != null) {
                while (q.right != null && q.right != p) {
                    q = q.right;
                }
                if (q.right == p) {
                    for (TreeNode r = p.left; ; r = r.left) {
                        TreeNode tmp = r.left;
                        r.left = r.right;
                        r.right = tmp;
                        if (r == q) {
                            break;
                        }
                    }
                    q.left = null;
                } else {
                    q.right = p;
                    p = p.left;
                    continue;
                }
            }
            p = p.right;
        }
        return dummy.left;
    }

}
