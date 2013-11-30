/*
Given m arrays, and each array is sorted in ascending order. Now you can pick
up two integers from two different arrays (each array picks one) and calculate
the distance. We define the difference between two integers a and b to be
their absolute difference |a-b|. Your task is to find the maximum difference.

 Notice

Each given array will have at least 1 number. There will be at least two
non-empty arrays.
The total number of the integers in all the m arrays will be in the range of
[2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].

Example
Given arrays = [[1,2,3], [4,5], [1,2,3]]
Return 4

One way to reach the maximum difference 4 is to pick 1 in the first or third
array and pick 5 in the second array.
 */
public class MaximumDifferenceInArrays {

    /*
     * @param : an array of arrays
     * @return: return the max distance among arrays
     */
    // ERROR
    public int maxDiff(int[][] arrs) {
        for (int i = 0; i < arrs.length; ++i) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arrs[i].length; ++j) {
                max = Math.max(max, arrs[i][j]);
                min = Math.min(min, arrs[i][j]);
            }
            arrs[i][0] = min;
            arrs[i][arrs[i].length - 1] = max;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arrs.length; ++i) {
            for (int j = i + 1; j < arrs.length; ++j) {
                int a = Math.abs(arrs[i][arrs[i].length - 1] - arrs[j][0]);
                int b = Math.abs(pair[j][arrs[j].length - 1] - arrs[i][0]);
                result = Math.max(result, Math.max(a, b));
            }
        }
        return result;
    }

}
