/*
 * Problem Statement

Sansa has an array. She wants to find the value obtained by XOR-ing the 
contiguous subarrays, followed by XOR-ing the values thus obtained. Can you 
help her in this task?

Note : [5,7,5] is contiguous subarray of [4,5,7,5] while [4,7,5] is not.

Input Format 
First line contains an integer T, number of the test cases. 
The first line of each test case contains an integer N, number of elements in 
the array. 
The second line of each test case contains N integers that are elements of the 
array.

Output Format 
Print the answer corresponding to each test case in a separate line.

Constraints 
1 ≤T ≤5 
2 ≤N ≤10^5 
1 ≤numbers in array ≤10^8

Sample Input

2
3
1 2 3
4
4 5 7 5
Sample Output

2
0
Explanation

Test case #00: 
1⊕2⊕3⊕(1⊕2)⊕(2⊕3)⊕(1⊕2⊕3)=2 

Test case #01: 
4⊕5⊕7⊕5⊕(4⊕5)⊕(5⊕7)⊕(7⊕5)⊕(4⊕5⊕7)⊕(5⊕7⊕5)⊕(4⊕5⊕7⊕5)=0
 */
import java.util.Scanner;

public class SansaAndXOR {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            int N = sc.nextInt();
            int xor = 0;
            for (int j = 0; j < N; ++j) {
                int value = sc.nextInt();
                if ((j + 1) * (N - j) % 2 != 0) {
                    xor ^= value;
                }
            }
            System.out.println(xor);
        }
    }

}
