/*
75. Encoding

time limit per test: 0.25 sec.
memory limit per test: 4096 KB
input: standard
output: standard



Let phi(W) is the result of encoding for algorithm: 
1.	If the length of W is 1 then phi(W) is W; 
2.	Let coded word is W = w1w2...wN and K = N / 2 (rounded down); 
3.	phi(W) = phi(wNwN-1...wK+1) + phi(wKwK-1...w1). 
For example, phi('Ok') = 'kO', phi('abcd') = 'cdab'. 
Your task is to find position of letter wq in encoded word phi(W).

Input
Given integers N, q (1 <= N <= 10^9; 1<= q <= N), where N is the length of word W.

Output
Write position of letter wq in encoded word phi(W).

Sample test(s)

Input
9 4

Output
8
 * 
 */
import java.util.*;

public class P175 {
    public static int phi(int n, int q) {
        if(q > n)
            return -1;
        if(n == 1)
            return 1;
        if(q <= n / 2)
            return phi(n / 2, n / 2 + 1 - q) + (n + 1) / 2;
        return phi((n + 1) / 2, n + 1 - q);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        System.out.println(phi(n, q));
    }   
}
