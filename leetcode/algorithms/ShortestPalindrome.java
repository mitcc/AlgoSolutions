/*
 * Given a string S, you are allowed to convert it to 
 * a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can 
 * find by performing this transformation.

 * For example:

 * Given "aacecaaa", return "aaacecaaa".

 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int i = len - 1;
        for (; i >= 0; --i) {
            if (isPalindrome(s, 0, i)) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(i + 1));
        sb.reverse().append(s);
        return sb.toString();
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

/*******************************************************************/

    public String shortestPalindrome(String s) {
        if (s.length() <= 1) 
            return s;
        String result = null;
        for (int i = (s.length() - 1) / 2; i >= 0; --i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if ((result = check(s, i, i + 1)) != null)
                    return result;
            } 
            if ((result = check(s, i, i)) != null) 
                return result;
        }
        return result;
    }

    public String check(String s, int left, int right) {
        int i = 1;
        for (; left - i >= 0 && right + i < s.length(); ++i) {
            if (s.charAt(left - i) != s.charAt(right + i)) {
                break;
            }
        }
        if (left - i >= 0)
            return null;
        StringBuffer sb = new StringBuffer(s.substring(right + i));
        return sb.reverse().append(s).toString();
    }

}
