/*
 * Given a string s and a dictionary of words dict, determine if s can be 
 * segmented into a space-separated sequence of one or more dictionary words.

 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].

 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        for(int i = 0; i < s.length(); i++) {
            if(i > 0 && !dp[i])
                continue;
            for(int j = s.length(); j > i; j--) {
                dp[j] = dp[j] || dict.contains(s.substring(i, j));
            }  
        }
        return dp[s.length()];
    }
}
