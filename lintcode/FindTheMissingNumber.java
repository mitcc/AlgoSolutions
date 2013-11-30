/*
 * Given an array contains N numbers of 0 .. N, find 
 * which number doesn't exist in the array.

Example
Given N = 3 and the array [0, 1, 3], return 2.

Challenge
Do it in-place with O(1) extra memory and O(n) time.
 */
public class FindTheMissingNumber {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */

    public int findMissing(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; ++i) {
            xor ^= (i + 1) ^ nums[i];
        }
        return xor;
    }

/*********************************************************/

    public int findMissing(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        return (int) (n * (n + 1) / 2 - sum);
    }

}
