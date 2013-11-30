/*
 * A message containing letters from A-Z is being 
 * encoded to numbers using the following mapping:

 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, 
 * determine the total number of ways to decode it.

 * For example,
 * Given encoded message "12", it could be decoded 
 * as "AB" (1 2) or "L" (12).

 * The number of ways decoding "12" is 2.
 */

public class DecodeWays {

    // O(n) time, O(n) space.
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            if (s.charAt(i - 2) == '1' || s.charAt(i - 1) <= '6' && 
                    s.charAt(i - 2) == '2')
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }

/*******************************************************************/

    // O(n) time, O(1) space.
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int pre = 1;
        int cur = 1;
        for (int i = 2; i <= s.length(); i++) {
            int next = 0;
            if (s.charAt(i - 1) != '0')
                next += cur;
            if (s.charAt(i - 2) == '1' || s.charAt(i - 1) <= '6' && 
                    s.charAt(i - 2) == '2')
                next += pre;
            pre = cur;
            cur = next;
        }
        return cur;
    }

}
