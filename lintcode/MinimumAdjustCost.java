/*
 * Given an integer array, adjust each integers so that the difference of every 
 * adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should 
minimize the sum of |A[i]-B[i]|

 Notice

You can assume each number in the array is a positive integer and not greater 
than 100.

Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the 
adjustment cost is 2 and it's minimal.

Return 2.
 */
public class MinimumAdjustmentCost {

    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = 0;
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            
        }
        return result;
    }

}
