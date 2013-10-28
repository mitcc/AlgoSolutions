/* 
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 * Below is one possible representation of s1 = "great":

 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.

 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".

 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".

 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {
/*  public boolean isScramble(String s1, String s2) {
        int N = s1.length();
        if(s2.length() != N)
            return false;
        boolean[][][] dp = new boolean[N][N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for(int len = 1; len < N; len++) {
            for(int i = 0; i + len < N; i++) {
                for(int j = 0; j + len < N; j++) {
                    for(int k = 0; k < len; k++) {
                        if(dp[i][j][k] && dp[i + k + 1][j + k + 1][len - 1 - k] 
                                || dp[i][j + len - k][k] && dp[i + k + 1][j][len - 1 - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][N - 1];
    }
*/   

    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) 
            return false;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!new String(c1).equals(new String(c2)))
            return false;
        if(s1.length() == 1)
            return true;
        for(int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))
                    || isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) 
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }
}
