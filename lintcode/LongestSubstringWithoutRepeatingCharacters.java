/*
 * Given a string, find the length of the longest substring without 
 * repeating characters.

Example
For example, the longest substring without repeating letters for 
"abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] occur = new int[128];
        for (int i = 0, startIndex = 0; i < s.length(); ++i) {
            startIndex = Math.max(startIndex, occur[s.charAt(i)]);
            result = Math.max(result, i - startIndex + 1);
            occur[s.charAt(i)] = i + 1;
        }
        return result;
    }

/*******************************************************************/

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        boolean[] occur = new boolean[127];
        for (int i = 0, j = 0; i < s.length(); ++i) {
            for (; j < s.length() && !occur[s.charAt(j)]; ++j) {
                occur[s.charAt(j)] = true;
            }
            result = Math.max(result, j - i);
            occur[s.charAt(i)] = false;
        }
        return result;
    }

}
