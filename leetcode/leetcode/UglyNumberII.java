/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For
example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly 
numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1, i2 = 0, i3 = 0, i5 = 0; i < n; ++i) {
            int next2 = result[i2] * 2;
            int next3 = result[i3] * 3;
            int next5 = result[i5] * 5;
            result[i] = Math.min(next2, Math.min(next3, next5));
            if (result[i] == next2) {
                i2++;
            }
            if (result[i] == next3) {
                i3++;
            }
            if (result[i] == next5) {
                i5++;
            }
        }
        return result[n - 1];
    }

}
