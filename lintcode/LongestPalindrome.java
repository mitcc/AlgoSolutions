/*
Given a string which consists of lowercase or uppercase letters, find the
length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

 Notice

Assume the length of given string will not exceed 1010.

Example
Given s = "abccccdd" return 7

One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {

    /*
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i)]++;
        }
        boolean hasOdd = false;
        int result = 0;
        for (int c : count) {
            result += c / 2 * 2;
            if (c % 2 != 0) {
                hasOdd = true;
            }
        }
        return result + (hasOdd ? 1 : 0);
    }

}
