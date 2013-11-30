/*
 * Given a string, determine if it is a palindrome, considering 
 * only alphanumeric characters and ignoring cases.

 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a 
 * good question to ask during an interview.

 * For the purpose of this problem, we define empty string as 
 * valid palindrome.
 */

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (ci < '0' || ci > '9' && ci < 'A' || 
                    ci > 'Z' && ci < 'a' || ci > 'z')
                i++;
            else if (cj < '0' || cj > '9' && cj < 'A' || 
                    cj > 'Z' && cj < 'a' || cj > 'z')
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

}
