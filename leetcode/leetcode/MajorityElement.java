/*
 * Given an array of size n, find the majority element. The majority element is 
 * the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always 
exist in the array.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        for (int i = 0, count = 0; i < nums.length; ++i) {
            count += nums[i] == candidate ? 1 : -1;
            if (count <= 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

}
