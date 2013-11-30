/*

112. a^b-b^a


time limit per test: 0.25 sec. 
memory limit per test: 4096 KB

You are given natural numbers a and b. Find a^b-b^a.

Input

Input contains numbers a and b (1≤a,b≤100).

Output

Write answer to output.

Sample Input

 2 3
Sample Output

 -1
 * 
 */
import java.math.BigInteger;
import java.util.*;

public class P112 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        BigInteger A = BigInteger.valueOf(a).pow(b);
        BigInteger B = BigInteger.valueOf(b).pow(a);
        System.out.println(A.subtract(B));
    }
}
