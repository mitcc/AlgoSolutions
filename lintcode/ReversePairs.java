/*
 * For an array A, if i < j, and A [i] > A [j], called 
 * (A [i], A [j]) is a reverse pair.
return total of reverse pairs in A.

Have you met this question in a real interview? Yes
Example
Given A = [2, 4, 1, 3, 5] , (2, 1), (4, 1), (4, 3) are 
reverse pairs. return 3
 */
public class ReversePairs {

    /**
     * @param A an array
     * @return total of reverse pairs
     */
    // TLE
    // O(nlg(n)) time, O(n) space.
    public long reversePairs(int[] A) {
        long result = 0;
        List<Integer> list = new LinkedList<Integer>();
        for (int i = A.length - 1; i >= 0; --i) {
            int low = 0;
            int high = list.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (A[i] > list.get(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            list.add(high, A[i]); 
            result += high;
        }
        return result;
    }

/*********************************************************/

    public long reversePairs(int[] A) {
        // Write your code here
        long result = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                if (A[i] > A[j]) {
                    result++;
                }
            }
        }
        return result;
    }

}
