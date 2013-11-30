/*
169. Numbers

time limit per test: 0.25 sec.
memory limit per test: 4096 KB
input: standard
output: standard



Let us call P(n) - the product of all digits of number n (in decimal notation). 
For example, P(1243)=1*2*4*3=24; P(198501243)=0. 
Let us call n to be a good number, if (p(n)<>0) and (n mod P(n)=0). 
Let us call n to be a perfect number, if both n and n+1 are good numbers. 

You are to write a program, which, given the number K, counts all such 
numbers n that n is perfect and n contains exactly K digits in decimal notation.

Input
Only one number K (1<=K<=1000000) is written in input.

Output
Output the total number of perfect k-digit numbers.

Sample test(s)

Input
1

Output
8
 * 
 */
import java.util.*;

public class P169 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  k = in.nextInt();
        int res = 0;
        if(k == 1)
            res = 8;
        if(k > 1) {
            res = 1;
            if((k - 1) % 3 == 0)
                res++;
            if((k + 5) % 3 == 0)
                res++;
            if((k - 1) % 6 == 0)
                res++;
        }
        System.out.println(res);
    }
}
