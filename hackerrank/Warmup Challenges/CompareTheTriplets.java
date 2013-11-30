/*
 * Alice and Bob each created one problem for HackerRank. A reviewer rates the 
 * two challenges, awarding points on a scale from  to  for three categories: 
 * problem clarity, originality, and difficulty.

We define the rating for Alice's challenge to be the triplet , and the rating 
for Bob's challenge to be the triplet .

Your task is to find their comparison scores by comparing  with ,  with , and  
with .

If , then Alice is awarded  point.
If , then Bob is awarded  point.
If , then neither person receives a point.
Given  and , can you compare the two challenges and print their respective 
comparison points?

Input Format

The first line contains  space-separated integers, , , and , describing the 
respective values in triplet . 
The second line contains  space-separated integers, , , and , describing the 
respective values in triplet .

Constraints

Output Format

Print two space-separated integers denoting the respective comparison scores 
earned by Alice and Bob.

Sample Input

5 6 7
3 6 10
Sample Output

1 1 
Explanation

In this example:

Now, let's compare each individual score:

, so Alice receives  point.
, so nobody receives a point.
, so Bob receives  point.
Alice's comparison score is , and Bob's comparison score is . Thus, we print 
1 1 (Alice's comparison score followed by Bob's comparison score) on a single 
line.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CompareTheTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int scoreA = (a0 > b0 ? 1 : 0) + (a1 > b1 ? 1 : 0) + (a2 > b2 ? 1 : 0);
        int scoreB = (a0 < b0 ? 1 : 0) + (a1 < b1 ? 1 : 0) + (a2 < b2 ? 1 : 0);
        System.out.println(scoreA + " " + scoreB);
    }

}
