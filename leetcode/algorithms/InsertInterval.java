/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 * You may assume that the intervals were initially sorted according to their start times.

 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
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
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int left = -1, right = -1;
        boolean leftIn = false, rightIn = false;
        for(int i = 0; i < intervals.size(); i++) {
            if(newInterval.start >= intervals.get(i).start) {
                left = i;
                leftIn = (newInterval.start <= intervals.get(left).end) ? true : false;
            }
            if(newInterval.end >= intervals.get(i).start) {
                right = i;
                rightIn = (newInterval.end <= intervals.get(right).end) ? true : false;
            }
        }  
        if(left == right) {
            if(leftIn && !rightIn) 
                intervals.get(right).end = newInterval.end;
            if(!leftIn && !rightIn)
                intervals.add(left + 1, newInterval);
        } else {
            intervals.get(right).start = leftIn ? intervals.get(left).start : newInterval.start;
            if(!rightIn)
                intervals.get(right).end = newInterval.end;
            for(int i = right - 1; i >= left + 1; i--) {
                intervals.remove(i);
            }
            if(leftIn)
                intervals.remove(left);
        }
        return intervals;
    }
}
