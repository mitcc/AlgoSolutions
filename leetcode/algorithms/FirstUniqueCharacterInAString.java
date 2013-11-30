/*
 * Given a string, find the first non-repeating character in 
 * it and return it's index. If it doesn't exist, return -1.

 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase 
 * letters.
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] count = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (count[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

}
