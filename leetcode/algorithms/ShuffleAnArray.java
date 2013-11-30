/*
 * Shuffle a set of numbers without duplicates.

 * Example:
 * 
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * 
 * // Shuffle the array [1,2,3] and return its result. Any permutation 
 * of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * 
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * 
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class ShuffleAnArray {

}

class Solution {
    
    int[] nums;
    int[] backup;

    public Solution(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
        this.backup = Arrays.copyOf(nums, nums.length);
    }
    
    /** Resets the nums to its original configuration and return it. */
    public int[] reset() {
        return backup;
    }
    
    /** Returns a random shuffling of the nums. */
    public int[] shuffle() {
        Random rnd = new Random();
        for (int i = nums.length; i > 1; --i) {
            swap(nums, i - 1, rnd.nextInt(i));
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
