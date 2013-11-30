/*
 * Given two strings s and t, write a function to determine if 
 * t is an anagram of s.

 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            dict[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            if (--dict[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }

/*******************************************************************/
    
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return new String(cs).equals(new String(ct));
    }

}
