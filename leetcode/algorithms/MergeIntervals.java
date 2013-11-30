/*
 * Given a collection of intervals, merge all overlapping intervals.

 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public clss MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start <= 
                    result.get(result.size() - 1).end)
                result.get(result.size() - 1).end = Math.max(result.
                        get(result.size() - 1).end, intervals.get(i).end);
            else
                result.add(intervals.get(i));
        } 
        return result;
    }

    class IntervalComparator implements Comparator<Interval> {
    
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }

    }

/*****************************************************************************/

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        quicksort(intervals, 0, intervals.size() - 1);
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start <= 
                    result.get(result.size() - 1).end)
                result.get(result.size() - 1).end = Math.max(result.
                        get(result.size() - 1).end, intervals.get(i).end);
            else
                result.add(intervals.get(i));
        } 
        return result;
    }

    public void quicksort(List<Interval> intervals, int low, int high) {
        if (low >= high)
            return;
        int i = low;
        for (int j = low; j < high; j++) {
            if (intervals.get(j).start <= intervals.get(high).start) {
                swap(intervals, i++, j);
            }
        }
        swap(intervals, i, high);
        quicksort(intervals, low, i - 1);
        quicksort(intervals, i, high);
    }

    public void swap(List<Interval> intervals, int i, int j) {
        Interval tmp = intervals.get(i);
        intervals.set(i, intervals.get(j));
        intervals.set(j, tmp);
    }

}
