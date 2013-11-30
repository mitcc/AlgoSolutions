/*
358. Median of Medians

Time limit per test: 0.25 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard



Vasya learned definition of median of three numbers. He says, "Median of three 
numbers is the number located in the middle when numbers are ordered in 
non-descending order". Subtle Pete gave him much more difficult task. Vasya has 
to find median of each of three triples and then find the median of three numbers 
he found. Please help Vasya with the task. 

Input
The input file contains three lines. Each line contains three integers. Each 
number is not less than -1000 and is not greater than 1000.

Output
Print one number - median of three medians.

Example(s)
sample input
sample output
6 4 5 
7 9 8 
1 2 3
5

sample input
sample output
1 2 2 
4 3 2 
2 3 4
3
 * 
 */

import java.util.*;

public class P358 {
    public static int getMedian(int a, int b, int c) {
        if(b <= a && a <= c || c <= a && a <= b)
            return a;
        if(a <= b && b <= c || c <= b && b <= a)
            return b;
        return c; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        int[] m = new int[3];
        for(int i = 0; i < 3; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            m[i] = getMedian(a, b, c);
        }
        System.out.println(getMedian(m[0], m[1], m[2]));
    }
}
