/*
 * Serialization is the process of converting a data structure or object into 
 * a sequence of bits so that it can be stored in a file or memory buffer, or 
 * transmitted across a network connection link to be reconstructed later in 
 * the same or another computer environment.

 * Design an algorithm to serialize and deserialize a binary tree. There is no 
 * restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and 
 * this string can be deserialized to the original tree structure.

 * For example, you may serialize the following tree

 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a 
 * binary tree. You do not necessarily need to follow this format, so please 
 * be creative and come up with different approaches yourself.
 * Note: Do not use class member/global/static variables to store states. Your 
 * serialize and deserialize algorithms should be stateless.
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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { 
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        curLevel.offer(root);
        while (!curLevel.isEmpty()) {
            TreeNode node = curLevel.poll();
            if (node != null) {
                sb.append(",").append(node.val);
                nextLevel.offer(node.left);
                nextLevel.offer(node.right);
            } else {
                sb.append(",#");
            }
            if (curLevel.isEmpty()) {
                curLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
            }
        }
        return sb.substring(1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        String[] s = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        curLevel.offer(root);
        int i = 1;
        while (!curLevel.isEmpty() && i < s.length) {
            TreeNode cur = curLevel.poll();
            if (!s[i].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(s[i]));
                nextLevel.offer(cur.left);
            } 
            if (!s[i + 1].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(s[i + 1]));
                nextLevel.offer(cur.right);
            } 
            i += 2;
            if (curLevel.isEmpty()) {
                curLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
            }
        }
        return root;
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}

public class SerializeAndDeserializeBinaryTree {

}
