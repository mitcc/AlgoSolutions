/*
 * Given a string s consists of upper/lower-case alphabets 
 * and empty space characters ' ', return the length of 
 * last word in the string.

If the last word does not exist, return 0.

Example
Given s = "Hello World", return 5.

Note
A word is defined as a character sequence consists of 
non-space characters only.
 */
public class LengthOfLastWord {

    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                int j = i;
                for (; j >= 0 && s.charAt(j) != ' '; --j);
                return i - j;
            }
        }
        return 0;
    }

}
