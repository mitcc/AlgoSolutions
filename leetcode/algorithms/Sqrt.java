/*
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
public class Sqrt {

    public int sqrt(int x) {
        int result = 0;
        for (int bit = 1 << 15; bit > 0; bit >>>= 1) {
            result |= bit;
            if (result > x / result) {
                result ^= bit;
            }
        }
        return result;
    }

/*******************************************************************/
 
    public int sqrt(int x) {
        long result = x;
        while (result * result > x) {
            result = (result + x / result) / 2;
        }
        return (int) result;
    }

/*******************************************************************/

    public int sqrt(int x) {
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }

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
*/

}
