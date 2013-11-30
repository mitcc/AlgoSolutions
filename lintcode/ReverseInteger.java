/*
 * Reverse digits of an integer. Returns 0 when the 
 * reversed integer overflows (signed 32-bit integer).

Example
Given x = 123, return 321

Given x = -123, return -321
 */
public class ReverseInteger {

    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        int result = 0;
        while (n != 0) {
            if (result > Integer.MAX_VALUE / 10)
                return 0;
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }

}
