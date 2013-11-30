/*
 * Given a string which consists of lowercase or uppercase letters, find the 
 * length of the longest palindromes that can be built with those letters.

 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] counts = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            counts[s.charAt(i)]++;
        }
        int result = 0;
        boolean hasOdd = false;
        for (int count : counts) {
            result += count / 2 * 2;
            if (count % 2 == 1) {
                hasOdd = true;
            }
        }
        result += hasOdd ? 1 : 0;
        return result;
    }

}
