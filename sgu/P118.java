/*
118. Digital Root


time limit per test: 0.25 sec. 
memory limit per test: 4096 KB

Let f(n) be a sum of digits for positive integer n. If f(n) is one-digit number 
then it is a digital root for n and otherwise digital root of n is equal to 
digital root of f(n). For example, digital root of 987 is 6. Your task is to 
find digital root for expression A1*A2*бн*AN + A1*A2*бн*AN-1 + бн + A1*A2 + A1.

Input

Input file consists of few test cases. There is K (1<=K<=5) in the first line 
of input. Each test case is a line. Positive integer number N is written on the 
first place of test case (N<=1000). After it there are N positive integer 
numbers (sequence A). Each of this numbers is non-negative and not more than 109.

Output

Write one line for every test case. On each line write digital root for given 
expression.

Sample Input

 1
3 2 3 4
Sample Output

 5
 * 
 */
import java.math.*;
import java.util.*;

public class P118 {
    public static int f(String s) {
        int root = 0;
        for(int i = 0; i < s.length(); i++)
            root += s.charAt(i) - '0';
        if(root > 9)
            root = f("" + root);
        return root;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for(int i = 0; i < k; i++) {
            int n = in.nextInt();
            BigInteger sum = BigInteger.ZERO;
            BigInteger product = BigInteger.ONE;
            for(int j = 0; j < n; j++) {
                product = product.multiply(BigInteger.valueOf(in.nextInt()));
                sum = sum.add(product);
            }
            System.out.println(f(sum.toString()));
        }
    }
}
