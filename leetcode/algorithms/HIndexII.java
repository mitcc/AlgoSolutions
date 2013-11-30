/*
 * Follow up for H-Index: What if the citations array is sorted in 
 * ascending order? Could you optimize your algorithm?

 * Hint:

 * Expected runtime complexity is in O(log n) and the input is sorted.
 */
public class HIndexII {

    // O(log n)
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] < citations.length - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return citations.length - left;
    }

/*****************************************************************************/

    // O(n)
    public int hIndex(int[] citations) {
        int result = 0;
        for (int i = 0; i < citations.length; ++i) {
            result = Math.max(result, 
                    Math.min(citations[i], citations.length - i));
        }
        return result;
    }

}
