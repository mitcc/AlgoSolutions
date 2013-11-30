/*
 * Given a non-empty array of integers, return the k most frequent elements.

 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].

 * Note: 
 * You may assume k is always valid, 1 <= k <= number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is 
 * the array's size.
 */
public class TopKFrequentElements {

    // O(n) time, O(n) space.
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, 1 + (map.containsKey(num) ? map.get(num) : 0));
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            if (bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new ArrayList<Integer>();
            }
            bucket[map.get(key)].add(key);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; --i) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }

/*****************************************************************************/

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, 1 + (map.containsKey(num) ? map.get(num) : 0));
        }
        List<Map.Entry<Integer, Integer>> list = 
            new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, 
                Map.Entry<Integer, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.size() && result.size() < k; ++i) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

/*****************************************************************************/

    // O(n + n * lg(k)) time, O(n) space.
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<Map.Entry<Integer, Integer>>(k, 
                    new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, 
                Map.Entry<Integer, Integer> entry2) {
                return entry1.getValue() - entry2.getValue();
            }
        });
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, 1 + (map.containsKey(num) ? map.get(num) : 0));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }
        return result;
    }

}
