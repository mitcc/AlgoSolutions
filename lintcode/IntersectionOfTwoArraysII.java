/*
 * Given two arrays, write a function to compute 
 * their intersection.

 Notice

Each element in the result should appear as many 
times as it shows in both arrays.
The result can be in any order.
Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], 
return [2, 2].

Challenge 
What if the given array is already sorted? How 
would you optimize your algorithm?
What if nums1's size is small compared to num2's 
size? Which algorithm is better?
What if elements of nums2 are stored on disk, and 
the memory is limited such that you cannot load 
all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {

    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            map.put(num, 1 + (map.containsKey(num) ? map.get(num) : 0));
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }

}
