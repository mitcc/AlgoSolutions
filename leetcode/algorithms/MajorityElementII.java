/*
 * Given an integer array of size n, find all elements 
 * that appear more than ⌊ n/3 ⌋ times. The algorithm 
 * should run in linear time and in O(1) space.
 */
public class MajorityElementII {

    // O(n) time and O(1) space.
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int candidate0 = 0;
        int candidate1 = 0;
        int count0 = 0;
        int count1 = 0;
        for (int value : nums) {
            if (value == candidate0)
                count0++;
            else if (value == candidate1)
                count1++;
            else if (count0 == 0) {
                candidate0 = value;
                count0 = 1;
            } else if (count1 == 0) {
                candidate1 = value;
                count1 = 1;
            } else {
                count0--;
                count1--;
            }
        }
        count0 = 0;
        count1 = 0;
        for (int value : nums) {
            if (value == candidate0)
                count0++;
            if (value == candidate1)
                count1++;
        }
        if (count0 > nums.length / 3)
            result.add(candidate0);
        if (candidate0 != candidate1 && count1 > nums.length / 3)
            result.add(candidate1);
        return result;
    }

    // O(n) time, O(n) space.
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int value : nums) {
            int count = 0;
            if (map.containsKey(value)) 
                count = map.get(value);
            map.put(value, count + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3)
                result.add(entry.getKey());
        }
        return result;
    }

}
