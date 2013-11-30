/*
 * Implement pow(x, n).

Example
Pow(2.1, 3) = 9.261
Pow(0, 1) = 0
Pow(1, 0) = 1
Note
You don't need to care about the precision of your answer, 
it's acceptable if the expected answer and your answer 's 
difference is smaller than 1e-3.

Challenge
O(logn) time
 */
public class Pow {

    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = myPow(x, n / 2) * myPow(x, n / 2);
        if (n % 2 != 0) {
            if (n > 0) {
                result *= x;
            } else {
                result /= x;
            }
        }
        return result;
    }

}
