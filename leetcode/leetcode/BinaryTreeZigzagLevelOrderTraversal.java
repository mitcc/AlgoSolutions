/*
Given a binary tree, return the zigzag level order traversal of its nodes' 
values. (ie, from left to right, then right to left for the next level and 
alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
public class BinaryTreeZigzagLevelOrderTraversal {

    // without reversal operation.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> curLayer = new LinkedList<TreeNode>();
        Deque<TreeNode> nextLayer = new LinkedList<TreeNode>();
        curLayer.offerLast(root);
        List<Integer> list = new ArrayList<Integer>();
        while (!curLayer.isEmpty()) {
            if (result.size() % 2 == 0) {
                TreeNode node = curLayer.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    nextLayer.offerLast(node.left);
                }
                if (node.right != null) {
                    nextLayer.offerLast(node.right);
                }
            } else {
                TreeNode node = curLayer.pollLast();
                list.add(node.val);
                if (node.right != null) {
                    nextLayer.offerFirst(node.right);
                }
                if (node.left != null) {
                    nextLayer.offerFirst(node.left);
                }
            }
            if (curLayer.isEmpty()) {
                result.add(list);
                list = new ArrayList<Integer>();
                curLayer = nextLayer;
                nextLayer = new LinkedList<TreeNode>();
            }
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        boolean isL2R = true;
        Queue<TreeNode> curLayer = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLayer = new LinkedList<TreeNode>();
        curLayer.offer(root);
        while (!curLayer.isEmpty()) {
            TreeNode node = curLayer.poll();
            list.add(node.val);
            if (node.left != null) {
                nextLayer.offer(node.left);
            }
            if (node.right != null) {
                nextLayer.offer(node.right);
            }
            if (curLayer.isEmpty()) {
                if (!isL2R) {
                    Collections.reverse(list);
                }
                isL2R = !isL2R;
                result.add(list);
                list = new ArrayList<Integer>();
                curLayer = nextLayer;
                nextLayer = new LinkedList<TreeNode>();
            }
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        zigzagLevelOrder(root, 0, result);
        return result;
    }

    public void zigzagLevelOrder(TreeNode root, int level, 
            List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).add(0, root.val);
        }
        zigzagLevelOrder(root.left, level + 1, result);
        zigzagLevelOrder(root.right, level + 1, result);
    }

}
