/*
 * Problem Statement

Given a list containing N integers, calculate the XorSum of all the non-empty
subsets of the list and print the value of XorSum % (109+7).

XOR operation on a list is defined as the xor (¨’), of all the elements present
in it, e.g., 
XOR({A,B,C})=A¨’B¨’C.

XorSum of a list is the sum of the XORs of every possible non-empty subset of 
the list. 
For example, for list X={x1,x2,x3} all possible non-empty subsets are [{x1},
{x2},{x3},{x1,x2},{x1,x3},{x2,x3},{x1,x2,x3}] 
XorSum(X)=x1+x2+x3+(x1¨’x2)+(x1¨’x3)+(x2¨’x3)+(x1¨’x2¨’x3)
Input Format 
An integer T, denoting the number of testcases. 2¡ÁT lines follow.
Each testcase contains two lines, first line will contains an integer N
followed by second line containing N integers, a1,a2,¡­,aN, separated by a 
single space.

Output Format 
T lines, ith line containing the output of the ith testcase.

Constraints

1¡ÜT¡Ü5
1¡ÜN¡Ü105
0¡Üai¡Ü109, i¡Ê[1,n]
Sample Input #00

1
3
1 2 3
Sample Output #00

12
Explanation 
The given case will have 7 non-empty subsets whose XOR is given below

1=1
2=2
3=3
1¨’2=3
2¨’3=1
3¨’1=2
1¨’2¨’3=0
So sum of all such XORs is 12.
 */
import java.math.BigInteger;
import java.util.Scanner;

public class XoringNinja {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            BigInteger sum = BigInteger.ZERO;
            for (int j = 0; j < n; ++j) {
                sum = sum.or(BigInteger.valueOf(in.nextInt()));
            }
            sum = sum.multiply(BigInteger.valueOf(2).pow(n - 1)).
                mod(BigInteger.valueOf(1000000007));
            System.out.println(sum);
        }
    }

}
