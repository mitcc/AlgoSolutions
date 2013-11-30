/*
 * Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are 
in the given prime list primes of size k. For example, [1, 2, 4, 7, 
8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super 
ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Notice

1 is a super ugly number for any given primes.
The given numbers in primes are in ascending order.
0 < k <= 100, 0 < n <= 10^6, 0 < primes[i] < 1000
Example
Given n = 6, primes = [2, 7, 13, 19] return 13
 */
public class SuperUglyNumber {

    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result = new int[n];
        result[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; ++i) {
            result[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; ++j) {
                result[i] = Math.min(result[i], result[index[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; ++j) {
                if (result[i] == result[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }
        return result[n - 1];
    }

}
