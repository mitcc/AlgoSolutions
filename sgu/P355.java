/*
355. Numbers Painting

Time limit per test: 0.25 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard



Dr. Vasechkin wants to paint all numbers from 1 to N in such a way that if 
number A is divisible by number B, numbers A and B have different colors.

Help Dr. Vasechkin to find such a painting, where the number of the colors used 
is minimal.

Input
The input contains integer number N (1 <= N <= 10000). 

Output
Write the number of the colors M in the desired painting in the first line of 
the output. In the second line of the output write the desired painting of 
numbers from 1 to N. The used colors should be represented by numbers from 1 to 
M. If there are several solutions, choose any of them.

Example(s)
sample input               sample output
12                         4
                           1 2 2 3 2 3 2 4 3 3 2 4
 * 
 */
import java.util.*;

public class P355 {
    public static int binaryStringLength(int n) {
        int len = 1;
        while (n > 1) {
            len++;
            n /= 2;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(binaryStringLength(n));
        //System.out.println(Integer.toBinaryString(n).length());
        int color = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0)
                color++;
            System.out.print(color + " ");
        }
    } 
}
