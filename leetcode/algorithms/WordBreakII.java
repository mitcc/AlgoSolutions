/*
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where 
 * each word is a valid dictionary word.

 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (isWordBreak(s, wordDict))
            dfs(result, s, "", wordDict);
        return result;
    }

    public void dfs(List<String> result, String s, String sub, 
            Set<String> wordDict) {
        if (s.length() == 0) {
            result.add(sub.trim());
            return;
        }
        for (int i = 1; i <= s.length(); ++i) {
            if (wordDict.contains(s.substring(0, i))) {
                sub += " " + s.substring(0, i);
                dfs(result, s.substring(i), sub, wordDict);
                sub = sub.substring(0, sub.length() - i - 1);
            }
        }
    }

    public boolean isWordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0)
            return false;
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                if (wordDict.contains(s.substring(j, i + 1)) && 
                        (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }

}
