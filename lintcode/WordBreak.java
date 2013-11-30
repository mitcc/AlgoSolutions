/*
 * Given a string s and a dictionary of words dict, 
 * determine if s can be break into a space-separated 
 * sequence of one or more dictionary words.

Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".
 */
public class WordBreak {

    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxLen = getMaxLength(dict);
        for (int i = 0; i < s.length(); ++i) {
            if (i == 0 || dp[i]) {
                for (int j = i + 1; j <= s.length() && j <= i + maxLen; ++j) {
                    dp[j] = dp[j] || dict.contains(s.substring(i, j));
                }
            }
        }
        return dp[s.length()];
    }

    public int getMaxLength(Set<String> dict) {
        int result = 0;
        for (String s : dict) {
            result = Math.max(result, s.length());
        }
        return result;
    }

}
