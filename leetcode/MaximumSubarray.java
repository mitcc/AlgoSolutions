/* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */ 
public class MaximumSubarray {
/********************** updated 2013/11/26 *********************/
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, tempMax = 0;
        for(int i = 0; i < A.length; i++) {
            tempMax += A[i];
            if(max < tempMax) 
                max = tempMax;
            if(tempMax < 0)
                tempMax = 0;
        }
        return max;
    }

/****************** Below is from wikipedia ******************/
    public int maxSubArray(int[] A) {
        int max_so_far = A[0], max_ending_here = A[0];
        for(int i = 1; i < A.length; i++) {//recursion starts from 1.
            if(max_ending_here < 0)
                max_ending_here = A[i];
            else
                max_ending_here += A[i];
            if(max_ending_here >= max_so_far)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }
}
