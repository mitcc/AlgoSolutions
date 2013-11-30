public class Chapter5 {

    // 5.1
    // not consider negative number
    public int binInsert(int n, int m, int j, int i) {
        int left = n >> i << i;
        int right = n << (32 - j) >>> (32 - j);
        return left | (m << j) | right;
    }
    
    // 5.2
    public String printBin(double num) {
        String result = "0.";
        while (num > 0) {
            double twice = 2 * num;
            int integer = (int) twice;
            num = twice - integer;
            result += integer;
            if (result.length() >= 32) {
                return "Error";
            }
        }
        return result;
    }

    // 5.3
    public int[] getCloseNumber(int x) {
        return int[]{
            getPrev(x), getNext(x)
        };
    }

    public int getPrev(int x) {
        int i = 0;
        int count = 0;
        for (; i < 32; ++i) {
            if ((x >>> i & 1) == 1) {
                count++;
            }
            if ((x >>> i & 1) == 0 && (x >>> (i + 1) & 1) == 1) {
                break;
            }
        }
        int mask = ((1 << count) - 1) << (i - count);
        int result = x & ~(1 << i + 1) | (1 << i);
        result = result >>> i << i | mask;
        return result;
    }

    public int getNext(int x) {
        int i = 0;
        int count = 0;
        for (; i < 32; ++i) {
            if ((x >>> i & 1) == 1) {
                count++;
            }
            if ((x >>> i & 1) == 1 && (x >>> (i + 1) & 1) == 0) {
                break;
            }
        }
        int mask = (1 << (--count)) - 1;
        int result = x & ~(1 << i) | (1 << i + 1);
        result = result >>> i << i | mask;
        return result;
    }

    // 5.5
    public int calcCost(int A, int B) {
        // write code here
        int xor = A ^ B;
        int count = 0;
        while (xor != 0) {
            count++;
            xor &= xor - 1;
        }
        return count;
    }

    // 5.6
    // 此题要么使用不带符号的右移，要么带符号右移后，再将首位置零
    public int exchangeOddEven(int x) {
        return ((x & 0xAAAAAAAA) >>> 1) | ((x & 0x55555555) << 1);
    }

    public int exchangeOddEven(int x) {
        return (((x & 0xAAAAAAAA) >> 1) & 0x7FFFFFFF) | ((x & 0x55555555) << 1);
    }

    // 5.7
    public int findMissing(int[][] numbers, int n) {
        for (int i = 0; i < numbers.length; ++i) {
            if (i % 2 != numbers[i][0]) {
                return i;
            }
        }
        return numbers.length;
    }

}
