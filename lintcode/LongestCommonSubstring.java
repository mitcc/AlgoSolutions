/*
 * Given two strings, find the longest common substring.

Return the length of it.

 Notice

The characters in substring should occur continuously in 
original string. This is different with subsequence.

Example
Given A = "ABCD", B = "CBCE", return 2.

Challenge
O(n x m) time and memory.
 */
public class LongestCommonSubstring {

    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        int[] dp = new int[B.length() + 1];
        int result = 0;
        for (int i = 0; i < A.length(); ++i) {
            for (int j = B.length() - 1; j >= 0; --j) {
                dp[j + 1] = A.charAt(i) == B.charAt(j) ? dp[j] + 1 : 0;
                result = Math.max(result, dp[j + 1]);
            }
        }
        return result;
    }

/*****************************************************************************/

    public int longestCommonSubstring(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int result = 0;
        for (int i = 0; i < A.length(); ++i) {
            for (int j = 0; j < B.length(); ++j) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                result = Math.max(result, dp[i + 1][j + 1]);
            }
        }
        return result;
    }

/*****************************************************************************/

    public int longestCommonSubstring(String A, String B) {
        int result = 0;
        for (int i = 0; i < A.length(); ++i) {
            for (int j = 0; j < B.length(); ++j) {
                for (int k = 0; k + i < A.length() && k + j < B.length() 
                        && A.charAt(k + i) == B.charAt(k + j); ++k) {
                    result = Math.max(result, k + 1);
                }
            }
        }
        return result;
    }

}
