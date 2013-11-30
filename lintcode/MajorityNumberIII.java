/*
 * Given an array of integers and a number k, the majority number is 
 * the number that occurs more than 1/k of the size of the array.

Find it.

Have you met this question in a real interview? Yes
 Notice

There is only one majority number in the array.

Example
Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

Challenge
O(n) time and O(k) extra space
 */
public class MajorityNumberIII {

    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    // O(n) time, O(n) space.
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, 1 + (map.containsKey(num) ? map.get(num) : 0));
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.size() / k) {
                result = entry.getKey();
            }
        }
        return result;
    }

}
