/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 * What if the given tree could be any binary tree? Would your previous 
 * solution still work?

 * Note:

 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 * 
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        ArrayList<TreeLinkNode> cur = new ArrayList<TreeLinkNode>();
        cur.add(root);
        while (cur.size() != 0) {
            ArrayList<TreeLinkNode> next = new ArrayList<TreeLinkNode>();
            for (int i = 0; i < cur.size(); i++) {
                TreeLinkNode node = cur.get(i);
                if (node.left != null)
                    next.add(node.left);
                if (node.right != null)
                    next.add(node.right);
                if (i != cur.size() - 1) 
                    node.next = cur.get(i + 1);
            }
            cur = next;
        }
    }


/*****************************************************************************/

    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode next = null;
            TreeLinkNode cur = null;
            for (; root != null; root = root.next) {
                TreeLinkNode r = null;
                if (root.left != null) {
                    if (root.right != null)
                        root.left.next = root.right;
                    r = root.left;
                } else if (root.right != null)
                    r = root.right;
                if (r != null) {
                    if (next != null)
                        next.next = r;
                    else {
                        cur = r;
                        next = r;
                    }
                    if (next.next != null)
                        next = next.next;
     
                    if (next.next!= null)
                        next = next.next;
                }
            }
            root = cur;
        }
    }
}
