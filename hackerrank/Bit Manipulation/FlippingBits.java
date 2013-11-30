/*
 * Problem Statement

You will be given a list of 32 bits unsigned integers. You are required to 
output the list of the unsigned integers you get by flipping bits in its binary 
representation (i.e. unset bits must be set, and set bits must be unset).

Input Format

The first line of the input contains the list size T, which is followed by T 
lines, each line having an integer from the list.

Constraints

1 <= T <=100 
0 < integer < 2^32
Output Format

Output one line per element from the list with the requested result.

Sample Input

3 
2147483647 
1 
0
Sample Output

2147483648 
4294967294 
4294967295
Explanation

Take 1 for example, as unsigned 32-bits is 00000000000000000000000000000001 and 
doing the flipping we get 11111111111111111111111111111110 which in turn is 
4294967294.
 */
import java.util.Scanner;

public class FlippingBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; ++i) {
            long v = sc.nextLong();
            System.out.println((long) Math.pow(2, 32) - 1 - v);
        }
    }

}
