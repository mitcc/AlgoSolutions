/*
 * Implement pow(x, n).
 */
package info.mitcc.leetcode;

public class Pow {
	public double pow(double x, int n) {
//        double result = 1.00000;
//        if(x == 0 && n <= 0)
//        	throw new IllegalArgumentException();
//        for(int i = 1; i <= Math.abs(n); i++) 
//        	result *= x;
//		return n >= 0 ? result : (1 / result);
		
        if(n == 0)
        	return 1;
        double half = pow(x, n / 2);
        if(n % 2 == 0) 
        	return half * half;
        else if(n > 0)
        	return half * half * x;
        return half * half / x;
    }
}
