/*
 * Given an array of integers, find out whether there 
 * are two distinct indices i and j in the array such 
 * that the difference between nums[i] and nums[j] is 
 * at most t and the difference between i and j is 
 * at most k.
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int floor = nums[i] <= Integer.MIN_VALUE + t ? 
                Integer.MIN_VALUE : nums[i] - t;
            int ceiling = nums[i] >= Integer.MAX_VALUE - t ? 
                Integer.MAX_VALUE : nums[i] + t + 1;
            if (t >= 0 && set.subSet(floor, ceiling).size() > 0)
                return true;
            set.add(nums[i]);
            if (i >= k) 
                set.remove(nums[i - k]);
        }
        return false;
    }

/*****************************************************************************/

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int v = nums[i];
            if (t >= 0 && (set.floor(v) != null && v <= set.floor(v) + t || 
                        set.ceiling(v) != null && v >= set.ceiling(v) - t))
                return true;
            set.add(v);
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }

}
