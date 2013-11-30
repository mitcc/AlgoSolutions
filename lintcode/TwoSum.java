/*
 * Given an array of integers, find two numbers such that they add up 
 * to a specific target number.

The function twoSum should return indices of the two numbers such 
that they add up to the target, where index1 must be less than 
index2. Please note that your returned answers (both index1 and 
index2) are NOT zero-based.

Example
numbers=[2, 7, 11, 15], target=9

return [1, 2]

Note
You may assume that each input would have exactly one solution

Challenge
Either of the following solutions are acceptable:

O(n) Space, O(nlogn) Time
O(n) Space, O(n) Time
 */
public class TwoSum {

    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; ++i) {
            if (map.containsKey(numbers[i])) {
                return new int[] {map.get(numbers[i]), i + 1};
            }
            map.put(target - numbers[i], i + 1);
        }
        return null;
    }

}
