/*
 * You are given an integer array nums and you have to 
 * return a new counts array. The counts array has the 
 * property where counts[i] is the number of smaller 
 * elements to the right of nums[i].
 * 
 * Example:
 * 
 * Given nums = [5, 2, 6, 1]
 * 
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 */
public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; --i) {
            int low = 0;
            int high = list.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[i] > list.get(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            list.add(high, nums[i]);
            result.add(0, high);
        }
        return result;
    }

}
