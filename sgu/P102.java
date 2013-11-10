/*
102. Coprimes


time limit per test: 0.5 sec. 
memory limit per test: 4096 KB

For given integer N (1<=N<=104) find amount of positive numbers not greater than N that coprime 
with N. Let us call two positive integers (say, A and B, for example) coprime if (and only if) 
their greatest common divisor is 1. (i.e. A and B are coprime iff gcd(A,B) = 1).

Input

Input file contains integer N.

Output

Write answer in output file.

Sample Input

 9
Sample Output

 6
 */
import java.util.*;

public class P102 {
    public static int gcd(int m, int n) {
        while(n != 0) {
            int p = m % n;
            m = n;
            n = p;
        }
        return m;
    }

    public static int totient_1(int n) {
        int count = 0;
        for(int i = 1; i < n; i++) {
            if(gcd(n, i) == 1)
                count++;
        }
        return count;
    }

    public static int totient_2(int n) {
        int count = 1, end = (int) Math.sqrt(n);
        for(int i = 2; i <= end; i++) {
            if(n % i == 0) {
                count *= i - 1;
                n /= i;
                while(n % i == 0) {
                    count *= i;
                    n /= i;
                }
                end = (int) Math.sqrt(n);
            }
        }
        if(n != 1)
            count *= n - 1;
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(totient_2(in.nextInt()));
    }
}
