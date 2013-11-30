/*
 *
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length
                    && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length && nums[i] == i + 1; ++i);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
