/*
 * Given a string S, find the longest palindromic substring in S. You may 
 * assume that the maximum length of S is 1000, and there exists one unique 
 * longest palindromic substring.

Example
Given the string = "abcdzdcab", return "cdzdc".

Challenge
O(n2) time is acceptable. Can you do it in O(n) time.
 */
public class LongestPalindromicSubstring {

    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    // O(n^2) time, O(n) time
    public String longestPalindrome(String s) {
        String result = "";
        String ss = new StringBuilder(s).reverse().toString();
        int[] dp = new int[ss.length() + 1];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = ss.length() - 1; j >= 0; --j) {
                dp[j + 1] = s.charAt(i) == ss.charAt(j) ? dp[j] + 1 : 0;
                if (result.length() < dp[j + 1]) {
                    result = ss.substring(j + 1 - dp[j + 1], j + 1);
                }
            }
        }
        return result;
    }

}
