package info.mitcc.leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int max = A[0], sum = 0;
		for(int i = 0; i < A.length; i++) {
        	sum += A[i];
        	if(max < sum)
        		max = sum;
        	if(sum < 0)
        		sum = 0;
        }
        return max;
		
        /**Below is from  wikipedia*/
/*		int max_so_far = A[0], max_ending_here = A[0];
		for(int i = 1; i < A.length; i++) {
			if(max_ending_here < 0)
				max_ending_here = A[i];
			else
				max_ending_here += A[i];
			if(max_ending_here >= max_so_far)
				max_so_far = max_ending_here;
		}
		return max_so_far;*/
    }
	
	public static void main(String[] args) {
		int[] array0 = {-2};
		int[] array1 = {-2, 1};
		int[] array2 = {-2, -1};
		int[] array3 = {-2, 1,-3, 4, -1, 2, 1, -5, 4};
		System.out.println(new MaximumSubarray().maxSubArray(array2));
	}
}
