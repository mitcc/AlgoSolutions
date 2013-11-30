/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return s == p;
        }
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i < len2; ++i) {
            if (p.charAt(i) == '*' && (dp[0][i] || i >= 1 && dp[0][i - 1])) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*' && j > 0) {
                    if (p.charAt(j - 1) != s.charAt(i)
                            && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                    if (p.charAt(j - 1) == '.'
                            || p.charAt(j - 1) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j]
                            || dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[len1][len2];
    }

/*****************************************************************************/

    public boolean isMatch(String s, String p) {
        if (p == null) {
            return s == null;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == '.' || p.equals(s));
        }
        if (p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || s.length() > 0
                && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
                && isMatch(s.substring(1), p);
        } else {
            return s.length() > 0 && (p.charAt(0) == '.'
                    || p.charAt(0) == s.charAt(0))
                && isMatch(s.substring(1), p.substring(1));
        }
    }

}
