/*
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Example
Clarification
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain 
leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInAString {

    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, j; i >= 0; i = j) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            sb.append(s.substring(j + 1, i + 1) + " ");
        }
        return sb.toString().trim();
    }

}
