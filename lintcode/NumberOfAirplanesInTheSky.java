/*
 * Given an interval list which are flying and landing time of the flight. How 
 * many airplanes are on the sky at most?

 Notice

If landing and flying happens at the same time, we consider landing should 
happen at first.

Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3
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
public class NumberOfAirplanesInTheSky {

    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        List<Point> list = new ArrayList<Point>();
        for (Interval airplane : airplanes) {
            list.add(new Point(airplane.start, 1));
            list.add(new Point(airplane.end, 0));
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.time == p2.time ? 
                    p1.flag - p2.flag : p1.time - p2.time;
            }
        });
        int result = 0;
        int count = 0;
        for (Point point : list) {
            count += point.flag == 1 ? 1 : -1;
            result = Math.max(result, count);
        }
        return result;
    }

    class Point {
        int time;
        int flag;

        Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }

}
