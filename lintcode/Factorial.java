/*
Given a number n, return the factorial of the number as a string.

Example
Given a number n = 20
return 2432902008176640000
 */
import java.math.BigDecimal;

public class Factorial {

    /*
     * @param : an integer
     * @return:  the factorial of n
     */
    public String factorial(int n) {
        BigDecimal bigDecimal = BigDecimal.ONE;
        for (int i = 1; i <= n; ++i) {
            bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(i));
        }
        return bigDecimal.toString();
    }

}
