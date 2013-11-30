/*
 * Given an unsorted array of integers, find the length 
 * of the longest consecutive elements sequence.

Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. 
Return its length: 4.

Clarification
Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {

    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            int low = num;
            int high = num + 1;
            while (set.contains(low)) {
                set.remove(low);
                low--;
            }
            while (set.contains(high)) {
                set.remove(high);
                high++;
            }
            result = Math.max(result, high - low - 1);
        }
        return result;
    }

}
