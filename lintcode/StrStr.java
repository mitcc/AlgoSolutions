/*
 * For a given source string and a target string, you should output the first 
 * index(from 0) of target string in source string.

If target does not exist in source, just return -1.

Example
If source = "source" and target = "target", return -1.

If source = "abcdabcdefg" and target = "bcd", return 1.

Challenge
O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)

Clarification
Do I need to implement KMP Algorithm in a real interview?

Not necessary. When you meet this problem in a real interview, the interviewer 
may just want to test your basic implementation ability. But make sure your 
confirm with the interviewer first.
 */
public class StrStr {

    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        for (int i = 0; i <= source.length() - target.length(); ++i) {
            int j = 0;
            for (; i + j < source.length() && j < target.length(); ++j) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }

/*****************************************************************************/

    public int strStr(String source, String target) {
        int[] next = getNext(target);
        
    }

    public int[] getNext(String p) {
        int[] next = new int[p.length()];
        next[0] = -1;
        int k = -1;
        int i = 0;
        while (i < p.length() - 1) {
            if (k == -1 || p.charAt(i) == p.charAt(k)) {
                ++i;
                ++k;
                if (p.charAt(i) != p.charAt(k)) {
                    next[i] = k;
                } else {
                    next[i] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
