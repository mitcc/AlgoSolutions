/*
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).

 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"

 * Minimum window is "BANC".

 * Note:
 * If there is no such window in S that covers all characters in T, 
 * return the emtpy string "".

 * If there are multiple such windows, you are guaranteed that 
 * there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] needFound = new int[256];
        int[] hasFound = new int[256];
        for (int i = 0; i < t.length(); ++i) {
            needFound[t.charAt(i)]++;
        }
        String result = "";
        int minLen = Integer.MAX_VALUE;
        int foundCount = 0;
        for (int startIndex = 0, i = 0; i < s.length(); ++i) {
            if (needFound[s.charAt(i)] == 0) {
                continue;
            }
            hasFound[s.charAt(i)]++;
            if (hasFound[s.charAt(i)] <= needFound[s.charAt(i)]) {
                foundCount++;
            }
            if (foundCount == t.length()) {
                while (needFound[s.charAt(startIndex)] == 0 || 
                        needFound[s.charAt(startIndex)] < 
                        hasFound[s.charAt(startIndex)]) {
                    hasFound[s.charAt(startIndex)]--;
                    startIndex++;
                }
                if (minLen > i - startIndex + 1) {
                    minLen = i - startIndex + 1;
                    result = s.substring(startIndex, i + 1);
                }
            }
        }
        return result;
    }

}
