/*
Given a string, determine if it is a palindrome, considering only alphanumeric 
characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to 
ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j;) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!Character.isLetterOrDigit(ci)) {
                i++;
            } else if (!Character.isLetterOrDigit(cj)) {
                j--;
            } else {
                if (ci != cj && (!Character.isLetter(ci) || 
                            !Character.isLetter(cj) 
                            || Math.abs(ci - cj) != 32)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

}
