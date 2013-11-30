/*
 * Find the contiguous subarray within an array (containing at least one 
 * number) which has the largest product.

 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

public class MaximumProductSubarray {

    public int maxProductHelper(int[] A, int start, int end) {
        if (start == end)
            return A[start];
        int negNum = 0;
        int product = 1;
        for (int i = start; i <= end; i++) {
            product *= A[i];
            if (A[i] < 0) {
                negNum += 1;
            }
        }
        if (negNum % 2 == 1) {
            int temp1 = 1;
            int temp2 = 1;
            for (int i = start; ; i++) {
                temp1 *= A[i];
                if (A[i] < 0)
                    break;
            }
            for (int i = end; ; i--) {
                temp2 *= A[i];
                if (A[i] < 0)
                    break;
            }
            product /= (temp1 < temp2 ? temp2 : temp1);
        }
        return product;
    }

    public int maxProduct(int[] A) {
        int maxProduct = Integer.MIN_VALUE;
        int start = 0; 
        for (int i = 0; i < A.length; i++) {  
            if (A[i] == 0) {
                maxProduct = Math.max(0, maxProduct);
                if (i >= 1)
                    maxProduct = Math.max(maxProduct, maxProductHelper(A, start, i - 1));
                while (i < A.length - 1 && A[i] == 0 && A[i + 1] == 0) {
                    i++;
                }
                start = i + 1;
            } else if (i == A.length - 1) {
                maxProduct = Math.max(maxProduct, maxProductHelper(A, start, i));
            } 
        }
        return maxProduct;
    }

}
