/*
 * One way to serialize a binary tree is to use pre-order 
 * traversal. When we encounter a non-null node, we record 
 * the node's value. If it is a null node, we record using 
 * a sentinel value such as #.
 * 
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to 
 * the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # 
 * represents a null node.
 * 
 * Given a string of comma separated values, verify whether 
 * it is a correct preorder traversal serialization of a 
 * binary tree. Find an algorithm without reconstructing 
 * the tree.
 * 
 * Each comma separated value in the string must be either 
 * an integer or a character '#' representing null pointer.
 * 
 * You may assume that the input format is always valid, 
 * for example it could never contain two consecutive 
 * commas such as "1,,3".
 * 
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * 
 * Example 2:
 * "1,#"
 * Return false
 * 
 * Example 3:
 * "9,#,#,1"
 * Return false
 */
public class VerifyPreorderSerializationOfABinaryTree {

    /*
     * If the node (including null node) has an in-degree, 
     * minus 1, and if it has an out-degree, plus 1.
     */
    public boolean isValidSerialization(String preorder) {
        int diff = 0;
        for (int i = 0; i < preorder.length(); ++i) {
            if (preorder.charAt(i) == ',') {
                continue;
            }
            if (i != 0 && --diff < 0) {
                return false;
            }
            if (Character.isDigit(preorder.charAt(i))) {
                for (; i < preorder.length() && 
                        Character.isDigit(preorder.charAt(i)); ++i);
                i--;
                diff += 2;
            }
        }
        return diff == 0;
    }

/*******************************************************************/

    public boolean isValidSerialization(String preorder) {
        int numCount = 0;
        for (int i = 0; i < preorder.length() - 2; ++i) {
            if (Character.isDigit(preorder.charAt(i))) {
                while (i < preorder.length() - 2 && 
                        Character.isDigit(preorder.charAt(i))) {
                    i++;
                }
                i--;
                numCount++;
            } else if (preorder.charAt(i) == '#') {
                if (--numCount < 0) {
                    return false;
                }
            }
        }
        return numCount == 0 && preorder.charAt(preorder.length() - 1) == '#';
    }

}
