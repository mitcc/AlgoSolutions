/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); ++i) {
            if (--hash[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

}
