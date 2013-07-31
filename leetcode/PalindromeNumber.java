/*
 * Determine whether an integer is a palindrome. Do this without extra space.

 * Some hints:
 * Could negative integers be palindromes? (ie, -1)

 * If you are thinking of converting the integer to string, note the restriction of using extra space.

 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
 * you know that the reversed integer might overflow. How would you handle such case?

 * There is a more generic way of solving this problem.
 */
package info.mitcc.leetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(x < 0) 
			return false;
        int rev = 0, digit, temp = x;
        while(temp != 0) {
        	digit = temp % 10;
        	rev = 10 * rev + digit;
        	temp /= 10;
        }
        return rev == x;
    }
}
