/*
Given an unsorted array of integers, find the length of the longest consecutive
elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {

    // O(n) time, O(n) space.
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                int consecLen = left + right + 1;
                map.put(num, consecLen);
                map.put(num - left, consecLen);
                map.put(num + right, consecLen);
                result = Math.max(result, consecLen);
            }
        }
        return result;
    }

/*****************************************************************************/

    // O(n) time, O(n) space.
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            set.add(num);
        }
        int result = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    set.remove(num++);
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }

/*****************************************************************************/

    // O(n) time, O(n) space.
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            set.add(num);
        }
        int result = 1;
        for (int num : nums) {
            int low = num;
            int high = num + 1;
            while (set.contains(low)) {
                set.remove(low--);
            }
            while (set.contains(high)) {
                set.remove(high++);
            }
            result = Math.max(result, high - low - 1);
        }
        return result;
    }

/*****************************************************************************/

    // O(n) time, O(n) space.
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 1;
        for (int num : nums) {
            int left = getConsecLen(set, num - 1, false);
            int right = getConsecLen(set, num + 1, true);
            result = Math.max(result, left + right + 1);
        }
        return result;
    }

    public int getConsecLen(Set<Integer> set, int num, boolean asc) {
        int consecLen = 0;
        while (set.contains(num)) {
            consecLen++;
            set.remove(num);
            num = asc ? num + 1 : num - 1;
        }
        return consecLen;
    }

/*****************************************************************************/

    // O(n) time, O(n) space.
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                if (map.containsKey(num - 1)) {
                    result = Math.max(result, merge(map, num - 1, num));
                }
                if (map.containsKey(num + 1)) {
                    result = Math.max(result, merge(map, num, num + 1));
                }
            }
        }
        return result;
    }

    public int merge(Map<Integer, Integer> map, int low, int high) {
        int upper = high + map.get(high) - 1;
        int lower = low - map.get(low) + 1;
        int len = upper - lower + 1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }

/*****************************************************************************/

    // O(nlg(n)) time, O(1) space.
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 1;
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                count = 1;
            }
            result = Math.max(result, count);
        }
        return result;
    }

}
