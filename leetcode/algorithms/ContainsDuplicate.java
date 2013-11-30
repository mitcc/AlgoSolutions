/*
 * Given an array of integers, find if the array 
 * contains any duplicates. Your function should 
 * return true if any value appears at least twice 
 * in the array, and it should return false if 
 * every element is distinct.
 */
public class ContainsDuplicate {

    // O(n) time, O(n) space.
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int value : nums) {
            if (!set.add(value))
                return true;
        }
        return false;
    }

/*********************************************************/

    // O(n * lg(n)) time, O(1) space.
    public boolean containDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }

}
