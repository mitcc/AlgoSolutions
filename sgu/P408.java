/*
408. Game with points

Time limit per test: 0.25 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard

Recently Petya has discovered new game with points. Rules of the game are quite 
simple. First, there is only one point A0 with coordinates (0, 0). Then Petya 
have to draw N another points. Points must be drawn consequently and each new 
point must be connected with exactly one of the previous points by a segment. 
Let's decribe the game process more formally. At the i-th step Petya chooses 
the position of the point Ai (not necessarily with integer coordinates). Than 
he chooses one of the previously drawn points in order to connect it with the 
point Ai. Lets call this point B. The following conditions must be held:
Point Ai must not coincide with any of the previous points.
Point Ai must not lie on the previously drawn segments.
Segment AiB must not have common points with previously drawn segments, except 
possibly the point B.
Segment AiB must not cover any of the previous points, except the point B.
Length of the segment AiB must not exceed 1. After drawing each point Petya 
computes two values.
The largest number of segments which share a common point.
The largest euclid distance between some pair of points. After each step Petya 
gains the score which is equal to the product of these values. Find out which 
is the maximal score Petya can gain after the whole game. 
Input
Input contains single integer number N (0 ¡Ü N ¡Ü 1000). 
Output
Output the maximal score that Petya can gain. Your answer must be accurate up 
to 10^-3. 
Example(s)
sample input     sample output
2                5.000

sample input     sample output
4                20.000
 * 
 */
import java.util.*;

public class P408 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = (n > 0) ? 1 : 0;
        for(int i = 2; i <= n; i++) 
            res += (i + 2) / 2 * ((i + 3) / 2);
        System.out.println(res);
    }
}
