/*
 * Given a string S, find the longest palindromic substring in S. You may assume that the 
 * maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
    /** Below cost O(n^2) time and O(n^2) space. */
    public String longestPalindrome(String s) {
        boolean[][] isPalin = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            isPalin[i][i] = true;
        }
        int beginAt = 0, maxLen = 1;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                isPalin[i][i + 1] = true;
                beginAt = i;
                maxLen = 2;
            }
        }
        for(int len = 3; len <= s.length(); len++) {
            for(int i = 0; i < s.length() + 1 - len; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && isPalin[i + 1][j - 1]) {
                    isPalin[i][j] = true;
                    beginAt = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(beginAt, beginAt + maxLen);
    }



    /** O(n^2) time and no space cost */
    public String expandAroundCenter(String s, int i, int j) {
        int left = i, right = j;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        String longest = "";
        for(int i = 0; i < s.length(); i++) {
            String expand = expandAroundCenter(s, i, i);
            if(longest.length() < expand.length())
                longest = expand;
            expand = expandAroundCenter(s, i, i + 1);
            if(longest.length() < expand.length())
                longest = expand;
        }
        return longest;
    }
}
