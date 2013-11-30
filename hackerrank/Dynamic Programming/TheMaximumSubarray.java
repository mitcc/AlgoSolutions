/*
 * Given an array  of  elements, find the maximum possible sum of a

Contiguous subarray
Non-contiguous (not necessarily contiguous) subarray.
Empty subarrays/subsequences should not be considered.

Input Format

First line of the input has an integer .  cases follow. 
Each test case begins with an integer . In the next line,  integers follow 
representing the elements of array .

Constraints:

The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and 
non-contiguous subarray. At least one integer should be selected and put into 
the subarrays (this may be required in cases where all elements are negative).

Sample Input

2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
Explanation

In the first case: 
The max sum for both contiguous and non-contiguous elements is the sum of ALL 
the elements (as they are all positive).

In the second case: 
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum. 
For the max sum of a not-necessarily-contiguous group of elements, simply add 
all the positive elements.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheMaximumSubarray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; ++i) {
            int N = in.nextInt();
            int[] array = new int[N];
            for (int j = 0; j < N; ++j) {
                array[j] = in.nextInt();
            }
            int sum1 = Integer.MIN_VALUE;
            int sum2 = 0;
            for (int j = 0, curSum1 = 0; j < N; ++j) {
                curSum1 += array[j];
                sum1 = Math.max(sum1, curSum1);
                if (curSum1 < 0) {
                    curSum1 = 0;
                }
                sum2 = j == 0 ? array[j] : 
                    Math.max(sum2 + array[j], Math.max(array[j], sum2));
            }
            System.out.println(sum1 + " " + sum2);
        }
    }

}
