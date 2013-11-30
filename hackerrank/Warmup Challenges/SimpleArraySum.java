/*
 * Problem Statement

You are given an array of integers of size N. Can you find the sum of the 
elements in the array?

Input 
The first line of input consists of an integer N. The next line contains N 
space-separated integers representing the array elements. 
Sample:

6
1 2 3 4 10 11
Output 
Output a single value equal to the sum of the elements in the array. 
For the sample above you would just print 31 since 1+2+3+4+10+11=31.
 */
public class SimpleArraySum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += in.nextInt();
        }
        System.out.println(sum);
    }

}
