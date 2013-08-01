/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.

 * For the purpose of this problem, we define empty string as valid palindrome.
 */
package info.mitcc.leetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        int i = 0, j = len - 1;
        while(i < j) {
        	char ci = s.charAt(i);
        	char cj = s.charAt(j);
        	if(ci < 48 ||( ci > 57 && ci < 65) || (ci > 90 && ci < 97) || ci > 122) 
        		i++;
        	else if(cj < 48 || (cj > 57 && cj < 65) || (cj > 90 && cj < 97) || ci > 122) 
        		j--;
        	else if(ci != cj && ci != ((cj <= 90) ? (cj + 32) : (cj - 32)))
        		return false;
        	else {
        		i++;
        		j--;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
//		String s = ".,";
		String s = "A man, a plan, a canal: Panama";
		System.out.println(new ValidPalindrome().isPalindrome(s));
	}
}
