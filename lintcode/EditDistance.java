/*
 * Given two words word1 and word2, find the minimum number 
 * of steps required to convert word1 to word2. (each 
 * operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example
Given word1 = "mart" and word2 = "karma", return 3.
 */
public class EditDistance {

    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); ++i) {
            for (int j = 0; j <= word2.length(); ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = j == 0 ? i : j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], 
                            Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }    
        return dp[word1.length()][word2.length()];
    }

}
