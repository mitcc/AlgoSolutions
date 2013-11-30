/*
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {

/**************************** updated 2014.03.08 *****************************/

    public int divide(int dividend, int divisor) {
        boolean flag = true;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            flag = false;
        int res = 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        while (a >= b) {
            int cnt = 0;
            while (a >= (b << (cnt + 1)))
                cnt++;
            res += 1 << cnt;
            a -= b << cnt;
        }
        return flag ? res : -res;
    }
}
