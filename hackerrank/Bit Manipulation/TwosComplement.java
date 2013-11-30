/*
 * Problem Statement

One of the basics of Computer Science is knowing how numbers are represented 
in 2's complement. Imagine that you write down all numbers between A and B 
inclusive in 2's complement representation using 32 bits. How many 1's will 
you write down in all ?

Input: 
The first line contains the number of test cases T (<=1000). Each of the next 
T lines contains two integers A and B.

Output: 
Output T lines, one corresponding to each test case.

Constraints: 
-2^31 <= A <= B <= 2^31 - 1

Sample Input: 
3 
-2 0 
-3 4 
-1 4

Sample Output: 
63 
99 
37

Explanation: 
For the first case, -2 contains 31 1's followed by a 0, -1 contains 32 1's and
0 contains 0 1's. Thus the total is 63. 
For the second case, the answer is 31 + 31 + 32 + 0 + 1 + 1 + 2 + 1 = 99
 */
public class TwosComplement {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; ++i) {
            int A = in.nextInt();
            int B = in.nextInt();
            System.out.println(solve(A, B));
        }
    }

    public static long solve(int a, int b) {
        if (a > b) {
            throw new IllegalArgumentException();
        }
        long count = 0;
        if (a < 0 && b < 0) {
            count = twosComplement(a) - twosComplement(b + 1);
        } else if (a < 0 && b >= 0) {
            count = twosComplement(a) + twosComplement(b);
        } else if (a >= 0 && b >= 0) {
            count = twosComplement(b) - twosComplement(Math.max(0, a - 1));
        }
        return count;
    }

    public static int hammingWeight(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        return (((n + (n >>> 4)) & 0x0f0f0f0f) * 0x01010101) >>> 24;
    }

    public static long twosComplement(int n) {
        if (n == 0) {
            return 0;
        } else if (n > 0) {
            if (n % 2 == 0) {
                return twosComplement(n - 1) + hammingWeight(n);
            }
            return ((long) n + 1) / 2 + 2 * twosComplement(n / 2);
        } else {
            return (-(long) n) * 32 - twosComplement(-n - 1);
        }
    }

}
