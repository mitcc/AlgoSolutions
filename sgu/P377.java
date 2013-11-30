/*
377. The Lesson of Physical Culture

Time limit per test: 0.75 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard



In one of the schools in Berland, the teacher of physical culture got cold 
during the morning excercises. After some discussion the pedagogical assembly 
has made a decision that the next lesson of physical culture will be driven by 
the teacher of mathematics Gleb Antonovich, who does not care whom, where and 
when he should talk about mathematics.

After coming to the gym, Gleb Antonovich noticed that the floor is the N x M 
grid of unit squares. The first exercise of the lesson was to stand in some 
cells in such a way that any student is in the center of some cell, there is 
no more than one student in any cell, and there are no more than two students 
in any 2x 2 square to prevent discomfort. But because of the limited space, it 
was required that each square 2x 2 must contain two students.

Gleb Antonovich is now interested, how many different ways of such standing 
exist if all students are equivalent. Your task is to find the number.

Input
The first line contains two integers N and M (2 ¡Ü N, M¡Ü 1000).

Output
Output the number of ways without any leading zeros or spaces. Note that the 
number of students standing on the floor is not fixed.

Example(s)
sample input
sample output
2 2
6
 * 
 */
import java.math.*;
import java.util.*;

public class P377 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BigInteger TWO = BigInteger.valueOf(2);
        System.out.println(TWO.pow(n).add(TWO.pow(m)).subtract(TWO));
    }
}
