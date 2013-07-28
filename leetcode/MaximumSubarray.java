package info.mitcc.leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] array) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int max = Integer.MIN_VALUE, sum = 0;
		for(int i = 0; i < array.length; i++) {
        	sum += array[i];
        	if(max < sum)
        		max = sum;
        	if(sum < 0)
        		sum = 0;
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] array0 = {-2};
		int[] array1 = {-2, 1};
		int[] array2 = {-2, -1};
		int[] array3 = {-2, 1,-3, 4, -1, 2, 1, -5, 4};
		System.out.println(new MaximumSubarray().maxSubArray(array3));
	}
}
