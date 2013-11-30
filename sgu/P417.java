/*
417. Heavy Disc

Time limit per test: 0.5 second(s)
Memory limit: 262144 kilobytes
input: standard
output: standard



Consider a heavy disc on the plane, centered at (x0,y0) with radius r, with the 
origin strictly outside it. The density of the disc is given by formula



What is the mass of the disc?

Input
The input file contains three integer numbers x0, y0, r (-100 ¡Ü x0, y0 ¡Ü 100, 
1 ¡Ü r ¡Ü 100, x02+y022).

Output
Output one real number ¡ª the mass of the disc. Your answer will be considered 
correct if it is within 10-12 relative error of the exact answer.

Example(s)
sample input        sample output
3 4 2               40.449586576894895
 * 
 */

import java.util.*;

public class P417 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int r = in.nextInt();
        System.out.println(Math.PI * r * r * Math.log(x * x + y * y));
    }

}
