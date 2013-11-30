/*
 * Implement int sqrt(int x).

Compute and return the square root of x.

Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Challenge
O(log(x))
 */
public class Sqrt {

    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        double i = 1.0;
        while ((int) i != (int) (x / i)) {
            i = (i + x / i) / 2;
        }
        return (int) i;
    }

/***********************************************/

    public int sqrt(int x) {
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < x / mid) {
                low = mid + 1;
            } else if(mid == x / mid) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return (low + high) / 2;
    }

}
