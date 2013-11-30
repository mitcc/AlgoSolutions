/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you 
have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 
10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a
32-bit integer, then the reverse of 1000000003 overflows. How should you handle
such cases?

For the purpose of this problem, assume that your function returns 0 when the 
reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.
 */
public class ReverseInteger {

    public int reverse(int x) {
        long reverse = 0;
        for (; x != 0; x /= 10) {
            reverse = 10 * reverse + x % 10;
            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) reverse;
    }

}
