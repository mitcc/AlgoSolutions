/*
 * We define a modified Fibonacci sequence using the following definition:

Given terms  and  where , term  is computed using the following relation:
For example, if term  and , term , term , term , and so on.

Given three integers, , , and , compute and print term  of a modified Fibonacci 
sequence.

Note: The value of  may exceed the range of a -bit integer. Many submission 
languages have libraries that can handle such large results but, for those that 
don't (e.g., C++), you will need to be more creative in your solution to 
compensate for the limitations of your chosen submission language.

Input Format

A single line of three space-separated integers describing the respective 
values of , , and .

Constraints

 may exceed the range of a -bit integer.
Output Format

Print a single integer denoting the value of term  in the modified Fibonacci 
sequence where the first two terms are  and .

Sample Input

0 1 5
Sample Output

5
Explanation

The first two terms of the sequence are  and , which gives us a modified 
Fibonacci sequence of . Because , we print term , which is .
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FibonacciModified {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger a = in.nextBigInteger();
        BigInteger b = in.nextBigInteger();
        int n = in.nextInt();
        for (int i = 1; i < n; ++i) {
            BigInteger tmp = a.add(b.pow(2));
            a = b;
            b = tmp;
        }
        System.out.println(a);
    }

}
