/*
 * Given an integer array (index from 0 to n-1, where n is the size of this 
 * array), and an query list. Each query has two integers [start, end]. For 
 * each query, calculate the sum number between index start and end in the 
 * given array, return the result list.

Example
For array [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]
 */
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class IntervalSum {

    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
        ArrayList<Long> result = new ArrayList<Long>();
        long[] sum = new long[A.length + 1];
        for (int i = 0; i < A.length; ++i) {
            sum[i + 1] = A[i] + sum[i];
        }
        for (Interval interval : queries) {
            result.add(sum[interval.end + 1] - sum[interval.start]);
        }
        return result;
    }

/*****************************************************************************/

    public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
        ArrayList<Long> result = new ArrayList<Long>();
        for (Interval interval : queries) {
            long sum = 0;
            for (int i = interval.start; i <= interval.end; ++i) {
                sum += A[i];
            }
            result.add(sum);
        }
        return result;
    }

}
