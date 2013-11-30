/*
 * Given an arbitrary ransom note string and another string containing letters 
 * from all the magazines, write a function that will return true if the ransom
 *  note can be constructed from the magazines ; otherwise, it will return 
 *  false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[256];
        for (int i = 0; i < magazine.length(); ++i) {
            hash[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            if (--hash[ransomNote.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

}
