/*
 * Given a string which contains only letters. Sort 
 * it by lower case first and upper case second.

Example
For "abAcD", a reasonable answer is "acbAD"

Note
It's not necessary to keep the original order 
of lower-case letters and upper case letters.

Challenge
Do it in one-pass and in-place.
 */
public class SortLettersByCase {

    public void sortLetters(char[] chars) {
        for (int i = 0, j = 0; i < chars.length; ++i) {
            if ('a' <= chars[i] && chars[i] <= 'z') {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j++] = tmp;
            }
        }
    }

/*********************************************************/

    public void sortLetters(char[] chars) {
        int i = 0; 
        int j = chars.length - 1;
        while (i < j) {
            if (isLowerCase(chars[i])) {
                i++;
            } else if (isUpperCase(chars[j])) {
                j--;
            } else {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
    }

    public boolean isLowerCase(char c) {
        return 'a' <= c && c <= 'z';
    }
    
    public boolean isUpperCase(char c) {
        return 'A' <= c && c <= 'Z';
    }

}
