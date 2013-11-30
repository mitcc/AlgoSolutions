/*
533. Dice Tower

Time limit per test: 1 second(s)
Memory limit: 262144 kilobytes
input: standard
output: standard

Polycarp loves not only to play games, but to invent ones as well. He has recently 
been presented with a board game which also had lots of dice. Polycarp quickly 
noticed an interesting phenomenon: the sum of dots on any two opposite sides 
equals 7.


Polycarp invented the following game. He asks somebody to tell a positive integer 
n and then he constructs a dice tower putting the dice one on another one. A 
tower is constructed like that: Polycarp puts a die on the table and then (if he 
wants) he adds more dice, each time stacking a new die on the top of the tower. 
The dice in the tower are aligned by their edges so that they form a perfect 
rectangular parallelepiped. The parallelepiped's height equals the number of 
dice in the tower and two other dimensions equal 1 (if we accept that a die's 
side is equal to 1).


Polycarp's aim is to build a tower of minimum height given that the sum of points 
on all its outer surface should equal the given number n (outer surface: the side 
surface, the top and bottom faces).

Write a program that would determine the minimum number of dice in the required 
tower by the given number n. Polycarp can construct any towers whose height equals 
1 or more.

Input
The only input line contains integer n (1 ¡Ü n ¡Ü 106).

Output
Print the only integer ¡ª the number of dice in the required tower. If no such 
tower exists, print -1.

Example(s)
sample input
sample output
50
3

sample input
sample output
7
-1

sample input
sample output
32
2
 * 
 */
import java.util.*;

public class P533 {
    public static int diceTower(int n) {
        int cnt = -1;
        int twoSizes = 0;
        while (twoSizes <= 0) {
            cnt++;
            twoSizes = 14 * cnt + 14 - n;
        }
        if (cnt == 1 && twoSizes == 7 || 
                cnt > 1 && twoSizes >= 2 && twoSizes <= 12) 
            return cnt;
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(diceTower(in.nextInt()));
    }
}
