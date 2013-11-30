/*
 * Implement wildcard pattern matching with support for '?' and '*'.

 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).

 * The matching should cover the entire input string (not partial).

 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)

 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "*") ? true
 * isMatch("aa", "a*") ? true
 * isMatch("ab", "?*") ? true
 * isMatch("aab", "c*a*b") ? false 
 */
public class WildcardMatching {
    /* This DP method can not access the judge large for Memory Limit Exceeded 
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][ p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= s.length(); i++) 
            dp[i][0] = (s.length() == 0);
        for(int i = 1; i <= p.length(); i++)
            dp[0][i] = dp[0][i - 1] && (p.charAt(i - 1) == '*');
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                if(p.charAt(j - 1) != '?' && p.charAt(j - 1) != '*')
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1)) && dp[i - 1][j - 1];
                if(p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                if(p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }
        }
        return dp[s.length()][p.length()];
    } 
    */

    /* This recursion can not access the judge large for Time Limit Exceeded 
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length() == 0;
        if(s.length() == 0)
            return p.length() == 0 || isAllStar(p);
        if((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '?')
            return isMatch(s.substring(1), p.substring(1));
        if(p.charAt(0) == '*')
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        else
            return false;
    }

    public boolean isAllStar(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '*')
                return false;
        }
        return true;
    }
    */

    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int star = -1, sp = 0;
        while(i < s.length()) {
            while(j < p.length() && p.charAt(j) == '*') {
                star = j++;
                sp = i;
            }
            if(j == p.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?')) {
                if(star < 0)
                    return false;
                else {
                    i = ++sp;
                    j = star;
                }
            } else {
                i++;
                j++;
            }
        }
        while(j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}
