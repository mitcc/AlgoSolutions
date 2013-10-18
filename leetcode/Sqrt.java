/*
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */

public class Sqrt {
/*  public int sqrt(int x) {
        if(x < 100) {
            int i = 0; 
            while(i * i <= x) {
                i++;
            }
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
            while(i * i + result * 20 * i <= nextProduct) {
                i++;
            }
            i--; 	
            tempDiff = nextProduct - (i * i + result * 20 * i);
            result = result * 10 + i;
        }
        return result;
    }



    public int sqrt(int x) {
        if(x < 0)
            throw new IllegalArgumentException("negative input");
        if(x == 0 || x == 1)
            return x;
        int start = 1;
        int end = x / 2 + 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(x / mid == mid)
                return mid;
            else if(mid < x / mid)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return (start + end) / 2;
    }
*/

    public int sqrt(int x) {
        if(x < 0)
            throw new IllegalArgumentException("negative input");
        double result = x;
        double last = 0;
        while(last != result) {
            last = result;
            result = (result + x / result) / 2;
        }
        return (int)result;
    }
}
