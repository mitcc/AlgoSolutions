/*
 * Alice is a kindergarden teacher. She wants to give some candies to the 
 * children in her class.  All the children sit in a line ( their positions are 
 * fixed), and each  of them has a rating score according to his or her 
 * performance in the class.  Alice wants to give at least 1 candy to each 
 * child. If two children sit next to each other, then the one with the higher 
 * rating must get more candies. Alice wants to save money, so she needs to 
 * minimize the total number of candies given to the children.

Input Format

The first line of the input is an integer N, the number of children in Alice's 
class. Each of the following N lines contains an integer that indicates the 
rating of each child.

Constraints
1 <= N <= 10 ^ 5
1 <= rating(i) <= 10 ^ 5

Output Format

Output a single line containing the minimum number of candies Alice must buy.

Sample Input

3  
1  
2  
2
Sample Output

4
Explanation

Here 1, 2, 2 is the rating. Note that when two children have equal rating, they 
are allowed to have different number of candies. Hence optimal distribution 
will be 1, 2, 1.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Candies {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ratings = new int[N];
        for (int i = 0; i < N; ++i) {
            ratings[i] = in.nextInt();
        }
        System.out.println(minCandies(ratings));
    }

    public static long minCandies(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        long result = 0;
        for (int candy : candies) {
            result += candy;
        }
        return result;
    }

}
