/*
495. Kids and Prizes

Time limit per test: 0.25 second(s)
Memory limit: 262144 kilobytes
input: standard
output: standard



ICPC (International Cardboard Producing Company) is in the business of producing 
cardboard boxes. Recently the company organized a contest for kids for the best 
design of a cardboard box and selected M winners. There are N prizes for the 
winners, each one carefully packed in a cardboard box (made by the ICPC, of 
course). The awarding process will be as follows:
All the boxes with prizes will be stored in a separate room.
The winners will enter the room, one at a time.
Each winner selects one of the boxes.
The selected box is opened by a representative of the organizing committee.
If the box contains a prize, the winner takes it.
If the box is empty (because the same box has already been selected by one or 
more previous winners), the winner will instead get a certificate printed on a 
sheet of excellent cardboard (made by ICPC, of course).
Whether there is a prize or not, the box is re-sealed and returned to the room.
The management of the company would like to know how many prizes will be given 
by the above process. It is assumed that each winner picks a box at random and 
that all boxes are equally likely to be picked. Compute the mathematical 
expectation of the number of prizes given (the certificates are not counted as 
prizes, of course).

Input
The first and only line of the input file contains the values of N and M ().

Output
The first and only line of the output file should contain a single real number: 
the expected number of prizes given out. The answer is accepted as correct if 
either the absolute or the relative error is less than or equal to 10-9.

Example(s)
sample input           sample output
5 7                    3.951424

sample input           sample output
4 3                    2.3125
 * 
 */
import java.util.*;

public class P495 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.printf("%.10f\n", n * (1 - Math.pow(1 - 1.0 / n, m)));
    }
}
