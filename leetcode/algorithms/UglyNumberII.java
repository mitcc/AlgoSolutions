/*
 * Write a program to find the n-th ugly number.

 * Ugly numbers are positive numbers whose prime factors 
 * only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 
 * 9, 10, 12 is the sequence of the first 10 ugly numbers.

 * Note that 1 is typically treated as an ugly number.

 * Hint:

 * 1. The naive approach is to call isUgly for every number 
 * until you reach the nth one. Most numbers are not ugly. 
 * Try to focus your effort on generating only the ugly ones.
 * 2. An ugly number must be multiplied by either 2, 3, or 5 
 * from a smaller ugly number.
 * 3. The key is how to maintain the order of the ugly 
 * numbers. Try a similar approach of merging from three 
 * sorted lists: L1, L2, and L3.
 * 4. Assume you have Uk, the kth ugly number. Then Uk+1 must 
 * be Min(L1 * 2, L2 * 3, L3 * 5).
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;
        for (int i = 1; i < n; ++i) {
            result[i] = Math.min(next2, Math.min(next3, next5));
            if (result[i] == next2) 
                next2 = result[++i2] * 2;
            if (result[i] == next3) 
                next3 = result[++i3] * 3;
            if (result[i] == next5) 
                next5 = result[++i5] * 5;
        }
        return result[n - 1];
    }

/*******************************************************************/

    public int nthUglyNumber(int n) {
        int k = n < 5 ? 5 : n;
        int[] result = new int[k];
        result[0] = 1;
        result[1] = 2;
        result[2] = 3;
        result[3] = 4;
        result[4] = 5;
        int i2 = 2;
        int i3 = 1;
        int i5 = 1;
        for (int i = 5; i < k; ++i) {
            result[i] = Math.min(result[i2] * 2, 
                    Math.min(result[i3] * 3, result[i5] * 5));
            if (result[i] == result[i2] * 2) 
                i2++;
            if (result[i] == result[i3] * 3) 
                i3++;
            if (result[i] == result[i5] * 5) 
                i5++;
        }
        return result[n - 1];
    }

}
