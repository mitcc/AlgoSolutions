/*
 * Write a function to find the longest common prefix string amongst an array 
 * of strings.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < strs.length; ++j) {
                if (i >= strs[j].length() || 
                        strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    } 

}
