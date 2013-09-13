/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String result = strs[0];
        for(int i = 1; i < strs.length; i++) {
            result = result.substring(0, Math.min(result.length(), strs[i].length()));
            for(int j = 0; j < result.length(); j++) {
                if(result.charAt(j) != strs[i].charAt(j)) {
                    result = result.substring(0, j);
                    break;
                }
            }
        }
        return result;
    }
}
