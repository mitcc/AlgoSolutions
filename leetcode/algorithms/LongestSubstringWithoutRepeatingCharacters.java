/*
 * Given a string, find the length of the longest substring 
 * without repeating characters. For example, the longest 
 * substring without repeating letters for "abcabcbb" is 
 * "abc", which the length is 3. For "bbbbb" the longest 
 * substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        boolean[] occur = new boolean[127];
        int result = 0;
        int i = 0; 
        int j = 0;
        while (j < s.length()) {
            if (occur[s.charAt(j)]) {
                result = Math.max(result, j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    occur[s.charAt(i++)] = false;
                }
                i++;
                j++;
            } else {
                occur[s.charAt(j++)] = true;
            }
        }
        return Math.max(result, s.length() - i);
    }

/*******************************************************************/

    public int lengthOfLongestSubstring(String s) {
        boolean[] occur = new boolean[127];
        int result = 0;
        for (int i = 0, j = 0; j < s.length(); i++) {
            for (; j < s.length() && !occur[s.charAt(j)]; j++) {
                occur[s.charAt(j)] = true;
            }
            result = Math.max(result, j - i);
            occur[s.charAt(i)] = false;
        }
        return result;
    }

}
