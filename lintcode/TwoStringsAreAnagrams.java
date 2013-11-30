/*
 * Write a method anagram(s,t) to decide if two 
 * strings are anagrams or not.

Example
Given s="abcd", t="dcab", return true.

Challenge
O(n) time, O(1) extra space
 */
public class TwoStringsAreAnagrams {

    /**
     * @param s: The first string
     * @param t: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        int[] letters = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            letters[s.charAt(i)]++;
            letters[t.charAt(i)]--;
        }
        for (int letter : letters) {
            if (letter != 0) {
                return false;
            }
        }
        return true;
    }

}
