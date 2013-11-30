/*
 * Problem Statement

You are given a square matrix of size N¡ÁN. Can you calculate the absolute 
difference of the sums across the two main diagonals?

Input Format

The first line contains a single integer N. The next N lines contain the rows 
of N integers describing the matrix.

Output Format

Output a single integer equal to the absolute difference in the sums across 
the diagonals.

Sample Input

3
11 2 4
4 5 6
10 8 -12
Sample Output

15
Explanation

The first diagonal of the matrix is:

11
    5
        -12
Sum across the first diagonal: 11 + 5 - 12 = 4

The second diagonal of the matrix is:

        4
    5
10
Sum across the second diagonal: 4 + 5 + 10 = 19 
Difference: |4 - 19| = 15
 */
public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int a = in.nextInt();
                if (i == j) {
                    sum1 += a;
                }
                if (i == n - 1 - j) {
                    sum2 += a;
                }
            }
        }
        System.out.println(Math.abs(sum1 - sum2));
    }

}
