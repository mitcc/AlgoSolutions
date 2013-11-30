/*
Given a string S, you are allowed to convert it to a palindrome by adding 
characters in front of it. Find and return the shortest palindrome you can find
by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {

    // O(n ^ 2) time.
    public String shortestPalindrome(String s) {
        int i = s.length() - 1;
        for (; i >= 0 && !isPalindrome(s, 0, i); --i);
        StringBuilder sb = new StringBuilder(s.substring(i + 1));
        sb = sb.reverse().append(s);
        return sb.toString();
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

}
