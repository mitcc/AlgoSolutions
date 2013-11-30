/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A 
is now [1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (index <= 1 || nums[index - 1] != nums[i] || 
                    nums[index - 2] != nums[index - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
