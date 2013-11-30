/*
 * Given an integer array, find a subarray with sum closest to zero. Return the 
 * indexes of the first number and last number.

Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].

Challenge 
O(nlogn) time
 */
public class SubarraySumClosest {

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        map.put(-1, 0);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            map.put(i, sum);
        }
        SortedSet<Map.Entry<Integer, Integer>> sortedSet = entriesSortedByValues(map);
        int closestSum = Integer.MAX_VALUE;
        int[] result = new int[2];
        Map.Entry<Integer, Integer> prevEntry = null;
        for (Map.Entry<Integer, Integer> entry :sortedSet) {
            if (prevEntry != null && (entry.getValue() - prevEntry.getValue() < closestSum)) {
                closestSum = entry.getValue() - prevEntry.getValue();
                result[0] = Math.min(entry.getKey(), prevEntry.getKey()) + 1;
                result[1] = Math.max(entry.getKey(), prevEntry.getKey());
            }
            prevEntry = entry;
        }
        return result;
    }

    public <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

/*****************************************************************************/

    public int[] subarraySumClosest(int[] nums) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<Map.Entry<Integer, Integer>>(1, 
                    new Comparator<Map.Entry<Integer, Integer>>() {
                            @Override
                            public int compare(Map.Entry<Integer, Integer> entry1,
                                               Map.Entry<Integer, Integer> entry2) {
                                return entry1.getValue() - entry2.getValue();
                            }
                        });
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(-1, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            map.put(i, sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int[] result = new int[2];
        Map.Entry<Integer, Integer> prevEntry = null;
        int closestSum = Integer.MAX_VALUE;
        while (pq.size() > 0) {
            if (prevEntry != null && pq.peek().getValue() - prevEntry.getValue() < closestSum) {
                closestSum = pq.peek().getValue() - prevEntry.getValue();
                result[0] = Math.min(pq.peek().getKey(), prevEntry.getKey()) + 1;
                result[1] = Math.max(pq.peek().getKey(), prevEntry.getKey());
            }
            prevEntry = pq.poll();
        }
        return result;
    }

}
