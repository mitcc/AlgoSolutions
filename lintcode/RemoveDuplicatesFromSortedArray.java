/*
 * Given a sorted array, remove the duplicates in place 
 * such that each element appear only once and return 
 * the new length.

Do not allocate extra space for another array, you must 
do this in place with constant memory.

Example
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (index == 0 || nums[index - 1] != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
