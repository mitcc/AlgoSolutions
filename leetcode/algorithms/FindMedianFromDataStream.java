/*
 * Median is the middle value in an ordered integer list. If the size 
 * of the list is even, there is no middle value. So the median is the 
 * mean of the two middle value.

 * Examples: 
 * [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to 
 * the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * 
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3) 
 * findMedian() -> 2
 */
class MediaFinder {
  
    List<Integer> list = new ArrayList<Integer>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        int i = 0;
        while (i < list.size() && list.get(i) < num) {
            i++;
        }
        list.add(i, num);
    }

    // Returns the median of current data stream
    public double findMedia() {
        int mid = list.size() / 2;
        if (list.size() % 2 == 1)
            return list.get(mid);
        else
            return (double) (list.get(mid - 1) + list.get(mid)) / 2;
    }

}
// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();

public class FindMediaFromDataStream {

}
