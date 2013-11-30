/*
 * Given a non-overlapping interval list which is sorted by start 
 * point.

Insert a new interval into it, make sure the list is still in order 
and non-overlapping (merge intervals if necessary).

Example
Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].

Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
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
public class InsertInterval {

    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, 
            Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                int newStart = Math.min(interval.start, newInterval.start);
                int newEnd = Math.max(interval.end, newInterval.end);
                newInterval = new Interval(newStart, newEnd);
            }
        }
        result.add(newInterval);
        return result;
    }
 
}
