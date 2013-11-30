/*
 * Given a string source and a string target, find the minimum window in source 
 * which will contain all the characters in target.

 Notice

If there is no such window in source that covers all characters in target, 
return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always 
be only one unique minimum window in source.

Clarification
Should the characters in minimum window has the same order in target?

Not necessary.
Example
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"

Challenge 
Can you do it in time complexity O(n) ?
 */
public class MinimumWindowSubstring {

    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        int[] needFound = new int[256];
        int[] hasFound = new int[256];
        for (int i = 0; i < target.length(); ++i) {
            needFound[target.charAt(i)]++;
        }
        String result = "";
        int minLen = Integer.MAX_VALUE;
        int foundCount = 0;
        for (int startIndex = 0, i = 0; i < source.length(); ++i) {
            if (needFound[source.charAt(i)] == 0) {
                continue;
            }
            hasFound[source.charAt(i)]++;
            if (hasFound[source.charAt(i)] <= needFound[source.charAt(i)]) {
                foundCount++;
            }
            if (foundCount == target.length()) {
                while (needFound[source.charAt(startIndex)] == 0 || 
                        needFound[source.charAt(startIndex)] < 
                        hasFound[source.charAt(startIndex)]) {
                    hasFound[source.charAt(startIndex)]--;
                    startIndex++;
                }
                if (minLen > i - startIndex + 1) {
                    minLen = i - startIndex + 1;
                    result = source.substring(startIndex, i + 1);
                }
            }
        }
        return result;
    }

}
