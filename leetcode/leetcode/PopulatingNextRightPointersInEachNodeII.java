/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode {

    // O(n) time, O(1) space.
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while (cur != null) {
            TreeLinkNode nextHead = null;
            TreeLinkNode prev = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (nextHead == null) {
                        nextHead = cur.left;
                    } else {
                        prev.next = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (nextHead == null) {
                        nextHead = cur.right;
                    } else {
                        prev.next = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = nextHead;
        }
    }

/*****************************************************************************/

    // O(n) time, O(n) space.
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> curLayer = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> nextLayer = new LinkedList<TreeLinkNode>();
        curLayer.offer(root);
        while (curLayer.peek() != null) {
            TreeLinkNode node = curLayer.poll();
            node.next = curLayer.peek();
            if (node.left != null) {
                nextLayer.offer(node.left);
            }
            if (node.right != null) {
                nextLayer.offer(node.right);
            }
            if (curLayer.peek() == null) {
                curLayer = nextLayer;
                nextLayer = new LinkedList<TreeLinkNode>();
            }
        }
    }

}
