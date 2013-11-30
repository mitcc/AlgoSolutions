/*
 * Given two strings s and t, determine 
 * if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in 
 * s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced 
 * with another character while preserving the 
 * order of characters. No two characters may map 
 * to the same character but a character may map 
 * to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 *
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

    public booleana isIsomorphic(String s, String t) {
        int[] array1 = new int[128];
        int[] array2 = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int c1 = s.charAt(i);
            int c2 = t.charAt(i);
            if (array1[c1] != 0 && array1[c1] != c2 ||
                    array2[c2] != 0 && array2[c2] != c1)
                return false;
            array1[c1] = c2;
            array2[c2] = c1;
        }
        return true;
    }

}
