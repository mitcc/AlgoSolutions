/*
 * Given a string, determine if it is a palindrome, considering 
 * only alphanumeric characters and ignoring cases.

Example
"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Note
Have you consider that the string might be empty? This is a good 
question to ask during an interview.

For the purpose of this problem, we define empty string as valid 
palindrome.
 */
public class ValidPalindrome {

    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        int i = 0; 
        int j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!isLetterOrNumber(ci))
                i++;
            else if (!isLetterOrNumber(cj))
                j--;
            else if (ci != cj && Math.abs(ci - cj) != 32)
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isLetterOrNumber(char c) {
        return 'a' <= c && c <= 'z' || 
            'A' <= c && c <= 'Z' || '0' <= c && c <= '9';
    }

}
