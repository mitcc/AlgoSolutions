/*
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)
Example
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "a*") ¡ú true
isMatch("aa", ".*") ¡ú true
isMatch("ab", ".*") ¡ú true
isMatch("aab", "c*a*b") ¡ú true
 */
public class RegularExpressionMatching {

    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); ++j) {
            dp[0][j + 1] = p.charAt(j) == '*' && dp[0][j - 1];
        }
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < p.length(); ++j) {
                if (p.charAt(j) != '.' && p.charAt(j) != '*') {
                    dp[i + 1][j + 1] = dp[i][j] && s.charAt(i) == p.charAt(j);
                } else if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (j >= 1) {
                        dp[i + 1][j + 1] = dp[i][j - 1] || dp[i + 1][j - 1] 
                            || (p.charAt(j - 1) == '.' 
                            || p.charAt(j - 1) == s.charAt(i)) && dp[i][j + 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        } else if (p.length() == 1) {
            return s.length() == 1 
                && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
        } else {
            if (p.charAt(1) != '*') {
                return s.length() > 0 
                    && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) 
                    && isMatch(s.substring(1), p.substring(1));
            } else {
                return s.length() > 0 
                    && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) 
                    && isMatch(s.substring(1), p) 
                    || isMatch(s, p.substring(2));
            }
        }
    }

}
