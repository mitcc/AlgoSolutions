/*
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
package info.mitcc.leetcode;

public class Sqrt {
	public int sqrt(int x) {
		if(x < 100) {
    		int i = 0; 
			while(i * i <= x)
				i++;
			return i - 1;
		}
		String number = x + "";
		int result = 0;
		int tempDiff;
		int nextProduct;
        int len = Integer.toString(x).length();
        int cursor = len % 2 == 1 ? 1 : 2;
        nextProduct = Integer.parseInt(number.substring(0, cursor));
        int divResult = sqrt(nextProduct);
        result += divResult;
        tempDiff = nextProduct - divResult * divResult;
        
        for(; cursor <= number.length() - 2; cursor += 2) {
        	nextProduct = 100 * tempDiff + Integer.parseInt(number.substring(cursor, cursor + 2));
        	int i = 0; 
        	while(i * i + result * 20 * i <= nextProduct)
        		i++;
        	i--; 	
        	tempDiff = nextProduct - (i * i + result * 20 * i);
        	result = result * 10 + i;
        }
        return result;
    }
}
