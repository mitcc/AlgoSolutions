/*
 * Given two arrays, write a function to compute their intersection.

 Notice

Each element in the result must be unique.
The result can be in any order.
Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Challenge 
Can you implement it in three different algorithms?
 */
public class IntersectionOfTwoArrays {

    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }

}
