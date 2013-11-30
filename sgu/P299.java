/*
299. Triangle

Time limit per test: 0.5 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard



It is well known that three segments can make a triangle if and only if the sum 
of lengths of any two of them is strictly greater than the length of the third 
one. Professor Vasechkin has N segments. He asked you, if you could find at 
least one set of three segments among them which can be used by professor to 
make a triangle. 

Input
The first line of the input contains the only integer number N (3¡Ü N¡Ü 1000). 
The following N lines contain the length of segments professor has. The length 
of any segment is the integer number from 1 to 10500.

Output
Write to the output the length of segments requested by the professor ¡ª three 
numbers delimited by spaces. Write three zeros if there are no such three 
segments.

Example(s)
sample input      sample output
7                 8 4 6
1
2
6
4
8
100
73
 */
import java.math.*;
import java.util.*;

public class P299 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger[] num = new BigInteger[n];
        for(int i = 0; i < n; i++)
            num[i] = in.nextBigInteger();
        Arrays.sort(num);
        for(int i = 0; i < n - 2; i++) {
            if(num[i].add(num[i + 1]).compareTo(num[i + 2]) > 0) {
                System.out.println(num[i] + " " + num[i + 1] + " " + num[i + 2]);
                return ;
            }
        }
        System.out.println("0 0 0");
    }
}
