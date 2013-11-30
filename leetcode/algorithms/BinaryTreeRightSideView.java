/*
 * Given a binary tree, imagine yourself 
 * standing on the right side of it, 
 * return the values of the nodes you 
 * can see ordered from top to bottom.

 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 */

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.remove();
            if (node.left != null)
                nextLevel.add(node.left);
            if (node.right != null)
                nextLevel.add(node.right);
            if (list.isEmpty()) {
                result.add(node.val);
                list = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
            }
        }
        return result;
    }

}
