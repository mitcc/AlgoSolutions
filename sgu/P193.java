/*
193. Chinese Girls' Amusement

time limit per test: 0.25 sec.
memory limit per test: 65536 KB
input: standard
output: standard



You must have heard that the Chinese culture is quite different from that of 
Europe or Russia. So some Chinese habits seem quite unusual or even weird to us. 

So it is known that there is one popular game of Chinese girls. N girls stand 
forming a circle and throw a ball to each other. First girl holding a ball 
throws it to the K-th girl on her left (1 ¡Ü K ¡Ü N/2). That girl catches the
ball and in turn throws it to the K-th girl on her left, and so on. So the ball 
is passed from one girl to another until it comes back to the first girl. If for 
example N = 7 and K = 3, the girls receive the ball in the following order: 1, 
4, 7, 3, 6, 2, 5, 1. 

To make the game even more interesting the girls want to choose K as large as 
possible, but they want one condition to hold: each girl must own the ball 
during the game. 

Input

Input file contains one integer number N (3 ¡Ü N ¡Ü 102000) - the number of 
Chinese girls taking part in the game. 

Output

Output the only number - K that they should choose. 

Sample test(s)

Input
Test #1 
7 

Test #2 
6 


Output
Test #1 
3 

Test #2 
1 
 * 
 */
import java.math.*;
import java.util.*;

public class P193 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        BigInteger TWO = BigInteger.valueOf(2);
        BigInteger half = n.divide(TWO);
        if (n.compareTo(BigInteger.ZERO) > 0 && 
                n.mod(TWO).equals(BigInteger.ZERO)) {
            half = half.mod(TWO).equals(BigInteger.ONE) ?  half.subtract(TWO) : 
                half.subtract(BigInteger.ONE);
            if (half.compareTo(BigInteger.ZERO) < 0)
                half = BigInteger.ONE;
        }
        System.out.print(half);
    } 
}
