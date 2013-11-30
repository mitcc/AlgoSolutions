/*
Check a positive number is a palindrome or not.

A palindrome number is that if you reverse the whole number you will get
exactly the same number.

 Notice

It's guaranteed the input number is a 32-bit integer, but after reversion, the
number may exceed the 32-bit integer.

Example
11, 121, 1, 12321 are palindrome numbers.

23, 32, 1232 are not palindrome numbers.
 */
public class PalindromeNumber {

    /**
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        int reverse = 0;
        int copy = num;
        for (; num != 0; num /= 10) {
            reverse = 10 * reverse + num % 10;
        }
        return reverse == copy;
    }

}
