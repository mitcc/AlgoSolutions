/*
 * Problem Statement

You saw a sample challenge in Solve Me First.

Here we give you a full challenge with all of the components that you typically 
see on HackerRank. In addition, we have provided a more elaborate I/O template
in your preferred language.

The given code starts by scanning two integers, separated by a single space, 
from STDIN in a loop over T lines. Then, it calls a sum function and prints out 
the return value to STDOUT.

Pseudocode:

read T
loop from 1 to T
    read A and B
    compute the sum
    print value in a newline
end loop
The code has already been provided for most of the popular languages. This is 
primarily for you to read and inspect how the I/O is handled.

Input Format

The first line contains T (number of test cases) followed by T lines. Each line 
contains A and B integers, separated by a space.

Output Format

An integer representing the sum for every test case on a new line.

Constraints 
1¡ÜT,A,B¡Ü1000
Sample Input

2
2 3
3 7
Sample Output

5
10
Explanation

The 2 in the first line describes how many test cases will follow, and the test 
case integers are 2, 3 and 3, 7 featured on two separate lines. Your output 
should be the sum of those test cases: 5 and 10 printed on two separate lines. 
If you print extra lines or any extra characters in your output, your answer 
will not get accepted because the judging is done using a diff checker.
 */
public class SolveMeSecond {

    static int solveMeSecond(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(solveMeSecond(a, b));
        }
    }

}
