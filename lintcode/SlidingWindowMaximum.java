/*
 * Given an array of n integer with duplicate number, and a moving 
 * window(size k), move the window at each iteration from the start 
 * of the array, find the maximum number inside the window at each 
 * moving.

Example
For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]

At first the window is at the start of the array like this

[|1, 2, 7| ,7, 8] , return the maximum 7;

then the window move one step forward.

[1, |2, 7 ,7|, 8], return the maximum 7;

then the window move one step forward again.

[1, 2, |7, 7, 8|], return the maximum 8;

Challenge 
o(n) time and O(k) memory
 */
public class SlidingWindowMaximum {

    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        int len = k == 0 ? 0 : nums.length - k + 1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            while (deque.size() > 0 && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.size() > 0 && deque.peekFirst() + k < i + 1) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }
        return result;
    }

}
