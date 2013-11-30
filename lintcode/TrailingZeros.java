/*
 * Write an algorithm which computes the 
 * number of trailing zeros in n factorial.

Example
11! = 39916800, so the out should be 2

Challenge
O(log N) time
 */
public class TrailingZeros {

    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long result = 0;
        while (n > 0) {
            n /= 5;
            result += n;
        }
        return result;
    }

}
