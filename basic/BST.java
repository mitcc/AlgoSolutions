import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST {

    private TreeNode root;

    BST() {
        root = null;
    }

    // insert
    public void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null)
            root = new TreeNode(value);
        else if (value <= root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
        return root;
    }

    // delete
    public void delete(int value) {
        root = delete(root, value);
    }

    public TreeNode delete(TreeNode root, int value) {
        if (root == null)
            return null;
        if (value < root.value)
            root.left = delete(root.left, value);
        else if (value > root.value)
            root.right = delete(root.right, value);
        else {
            if (root.right == null)
                return root.left;
            if (root.left == null)
                return root.right;
            TreeNode t = root;
            root = getMin(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        return root;
    }

    // deleteMin
    public TreeNode deleteMin(TreeNode root) {
        if (root.left == null)
            return root.right;
        root.left = deleteMin(root.left);
        return root;
    }

    // getMax
    public TreeNode getMax() {
        return getMax(root);
    }

    public TreeNode getMax(TreeNode root) {
        if (root.right == null)
            return root;
        return getMax(root.right);
    }

    // getMin
    public TreeNode getMin() {
        return getMin(root);
    }

    public TreeNode getMin(TreeNode root) {
        if (root.left == null)
            return root;
        return getMin(root.left);
    }

    public TreeNode getKthMin(int k) {
        return getKthMin(root, k);
    }

    public TreeNode getKthMin(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || stack.size() > 0) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                k--;
                if (k == 0)
                    return cur;
                cur = cur.right;
            }
        }
        return null;
    }

    public static List<TreeNode> inorderMorrisTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur);
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
                    result.add(cur);
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    public static List<TreeNode> preorderMorrisTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    result.add(cur);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }

}

class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

}
