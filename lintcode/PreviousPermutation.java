/*
 * Given a list of integers, which denote a permutation.

Find the previous permutation in ascending order.

 Notice

The list may contains duplicate integers.

Example
For [1,3,2,3], the previous permutation is [1,2,3,3]

For [1,2,3,4], the previous permutation is [4,3,2,1]
 */
public class PreviousPermutation {

    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermutation(ArrayList<Integer> nums) {
        int i = nums.size() - 2;
        while (i >= 0 && nums.get(i) <= nums.get(i + 1)) {
            i--;
        }
        if (i >= 0) {
            int j = i + 1;
            while (j + 1 < nums.size() && nums.get(j + 1) < nums.get(i)) {
                j++;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.size() - 1);
        return nums;
    }

    public void reverse(List<Integer> list, int i, int j) {
        while (i < j) {
            swap(list, i++, j--);
        }
    }
    
    public void swap(List<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

}
