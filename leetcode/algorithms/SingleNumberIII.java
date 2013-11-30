/*
 * Given an array of numbers nums, in which exactly 
 * two elements appear only once and all the other 
 * elements appear exactly twice. Find the two 
 * elements that appear only once.

 * For example:

 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 * Note:
 * The order of the result is not important. So in 
 * the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime 
 * complexity. Could you implement it using only 
 * constant space complexity?
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xor = 0;
        for (int value : nums) {
            xor ^= value;
        }
        int mask = xor & ~(xor - 1);
        for (int value : nums) {
            if ((mask & value) != 0)
                result[0] ^= value;
            else
                result[1] ^= value;
        }
        return result;
    }

/*******************************************************************/

    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int count = 1;
            if (map.containsKey(nums[i])) {
                count += map.get(nums[i]);
            }
            map.put(nums[i], count);
        }
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (map.get(nums[i]) == 1)
                result[k++] = nums[i];
        }
        return result;
    }

}
