/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while
preserving the order of characters. No two characters may map to the same
character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] index0 = new int[256];
        int[] index1 = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            if (index0[s.charAt(i)] != index1[t.charAt(i)]) {
                return false;
            }
            index0[s.charAt(i)] = i + 1;
            index1[t.charAt(i)] = i + 1;
        }
        return true;
    }

/*****************************************************************************/

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] map0 = new int[256];
        int[] map1 = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map0[cs] != 0 && map0[cs] != ct
                    || map1[ct] != 0 && map1[ct] != cs) {
                return false;
            }
            map0[s.charAt(i)] = t.charAt(i);
            map1[t.charAt(i)] = s.charAt(i);
        }
        return true;
    }

}
