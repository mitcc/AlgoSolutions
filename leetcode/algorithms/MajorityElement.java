/*
 * Given an array of size n, find the majority element. The majority 
 * element is the element that appears more than ⌊ n/2 ⌋ times.

 * You may assume that the array is non-empty and the majority 
 * element always exist in the array. 
 */
public class MajorityElement {

    public int majorityElement(int[] num) {
        int result = 0;
        int count = 0;
        for (int value : num) {
            count += value == result ? 1 : -1;
            if (count <= 0) {
                result = value;
                count = 1;
            }
        }
        return result;
    }

}
