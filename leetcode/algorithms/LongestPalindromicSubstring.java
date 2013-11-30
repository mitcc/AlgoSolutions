/*
 * Given a string S, find the longest palindromic substring in S. You may assume that the 
 * maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
/*
    // Below cost O(n^2) time and O(n^2) space. 
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



    // O(n^2) time and no space cost 
    public String expandAroundcenterenter(String s, int i, int j) {
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
            String expand = expandAroundcenterenter(s, i, i);
            if(longest.length() < expand.length())
                longest = expand;
            expand = expandAroundcenterenter(s, i, i + 1);
            if(longest.length() < expand.length())
                longest = expand;
        }
        return longest;
    }
*/


    /** O(n) time and O(n) space cost. */
    public String preProcess(String s) {
        if(s.length() == 0)
            return "#";
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            result += "#" + s.charAt(i);
        }
        result += "#";
        return result;
    }

    public String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int center = 0, rightMost = 0;
        for(int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * center - i;
            P[i] = rightMost > i ? Math.min(rightMost - i, P[i_mirror]) : 0; 
            while(i + 1 + P[i] < n && i >= 1 + P[i] && T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            if(P[i] > center) {
                center = i;
                rightMost = i + center;
            }
        }
        int maxLen = 0, beginAt = 0;
        for(int i = 1; i < n - 1; i++) {
            if(maxLen < P[i]) {
                maxLen = P[i];
                beginAt = i;
            }
        }
        return s.substring((beginAt - maxLen) / 2, (beginAt - maxLen)/ 2 + maxLen);
    }
}
