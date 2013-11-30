/*
 * Given an array of integers, the majority number is the 
 * number that occurs more than half of the size of the 
 * array. Find it.

Example
Given [1, 1, 1, 1, 2, 2, 2], return 1

Challenge
O(n) time and O(1) extra space
 */
public class MajorityNumber {

    public int majorityNumber(ArrayList<Integer> nums) {
        int vote = 0;
        int result = 0;
        for (int num : nums) {
            vote += num == result ? 1 : -1;
            if (vote <= 0) {
                result = num;
                vote = 1;
            }
        }
        return result;
    }

}
