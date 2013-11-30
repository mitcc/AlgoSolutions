/*
 * Given an unsorted array, find the maximum difference 
 * between the successive elements in its sorted form.

 * Try to solve it in linear time/space.

 * Return 0 if the array contains less than 2 elements.

 * You may assume all elements in the array are non-negative 
 * integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {

    // O(n) 
    public int maximumGap(int[] num) {
        if (num.length < 2)
            return 0;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int value : num) {
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);
        }
        double w = (double) (maxValue - minValue) / (num.length + 1);
        int[][] bucket = new int[2][num.length + 1];
        Arrays.fill(bucket[0], minValue);
        Arrays.fill(bucket[1], maxValue);
        for (int value : num) {
            int k = (int) Math.floor((value - minValue) / w);
            if (k == num.length + 1)
                k--;
            bucket[0][k] = Math.max(bucket[0][k], value);
            bucket[1][k] = Math.min(bucket[1][k], value);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1, j = 0; i < num.length + 1; i++) {
            if (bucket[0][i] != minValue) {
                result = Math.max(result, bucket[1][i] - bucket[0][j]);
                j = i;
            }
        }
        return result;
    }

/***********************************************************************/

    // O(n*log(n))
    public int maximumGap(int[] num) {
        Arrays.sort(num);
        int result = 0;
        for (int i = 1; i < num.length; i++) {
            result = Math.max(result, num[i] - num[i - 1]);
        }
        return result;
    }
    
}
