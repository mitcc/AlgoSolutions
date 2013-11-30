/*
 * Given a n x n matrix where each of the rows and columns are sorted 
 * in ascending order, find the kth smallest element in the matrix.

 * Note that it is the kth smallest element in the sorted order, not 
 * the kth distinct element.
 * 
 * Example:
 * 
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * Note: 
 * You may assume k is always valid, 1 <= k <= n ^ 2.
 */
public class KthSmallestElementInASortedMatrix {

    // time O(n * lg(matrix[matrix.length - 1][matrix[0].length - 1] -
    // matrix[0][0]))
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = searchSmallerCount(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int searchSmallerCount(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] <= target) {
                j++;
                count += i + 1;
            } else {
                i--;
            }
        }
        return count;
    }

/*******************************************************************/

    // time O(k * n), space O(max(n, k))
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<Integer>();
        int[] index = new int[matrix[0].length];
        while (list.size() < k) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < matrix[0].length; ++i) {
                if (index[i] < matrix.length) {
                    if (min >= matrix[index[i]][i]) {
                        min = matrix[index[i]][i];
                        minIndex = i;
                    }
                }
            }
            index[minIndex]++;
            list.add(min);
        }
        return list.get(k - 1);
    }

}
