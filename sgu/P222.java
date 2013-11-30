/*
222. Little Rooks

time limit per test: 0.25 sec.
memory limit per test: 65536 KB
input: standard
output: standard



Inspired by a "Little Bishops" problem, Petya now wants to solve problem for 
rooks. 

A rook is a piece used in the game of chess which is played on a board of square 
grids. A rook can only move horizontally and vertically from its current position 
and two rooks attack each other if one is on the path of the other. 

Given two numbers n and k, your job is to determine the number of ways one can 
put k rooks on an n ¡Á n chessboard so that no two of them are in attacking 
positions. 

Input

The input file contains two integers n (1 ¡Ü n ¡Ü 10) and k (0 ¡Ü k ¡Ü n2). 

Output

Print a line containing the total number of ways one can put the given number 
of rooks on a chessboard of the given size so that no two of them are in attacking 
positions. 

Sample test(s)

Input
4 4 

Output
24 
 * 
 */
import java.util.*;

public class P222 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(n < k)
            System.out.println(0);
        else {
            int res = 1;
            for(int i = 1; i <= k; i++) {
                res *=(n - i + 1) * (n - i + 1);
                res /= i;
            }
            System.out.println(res);
        }
    }
}
