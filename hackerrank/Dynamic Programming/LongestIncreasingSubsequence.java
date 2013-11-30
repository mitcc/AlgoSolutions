/*
 * Problem Statement

 * An Introduction to the Longest Increasing Subsequence Problems

 * The task is to find the length of the longest subsequence in a given array 
 * of integers such that all elements of the subsequence are sorted in 
 * ascending order. For example, the length of the LIS for { 15, 27, 14, 38, 
 * 26, 55, 46, 65, 85 } is 6 and the longest increasing subsequence is {15, 
 * 27, 38, 55, 65, 85}. 
 *
 * Input Format

In the first line of input, there is a single number N. 
In the next N lines input the value of a[i].

Constraints 
1 ¡Ü N ¡Ü 106 
1 ¡Ü a[i] ¡Ü 105

Output Format

In a single line, output the length of the longest increasing sub-sequence.

Sample Input

5
2
7
4
3
8
Sample Output

3
Explanation

{2,7,8} is the longest increasing sub-sequence, hence the answer is 3 (the 
length of this sub-sequence).
 */
import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; ++i) {
            nums[i] = sc.nextInt();
        }
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            if (list.size() == 0 || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int index = findPosition(list, num);
                list.set(index, num);
            }
        }
        return list.size();
    }

    public static int findPosition(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == list.get(mid)) {
                return mid;
            } else if (target < list.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
