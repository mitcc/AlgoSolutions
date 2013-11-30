/*
Implement pow(x, n).
 */
public class Pow {

    public double myPow(double x, int n) {
        long step = Math.abs((long) n);
        if (n < 0) {
            x = 1.0 / x;
        }
        double result = 1.0;
        while (step != 0) {
            if (step % 2 != 0) {
                result *= x;
            }
            x *= x;
            step >>= 1;
        }
        return result;
    }

/*****************************************************************************/

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = myPow(x, n / 2);
        double result = half * half;
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
