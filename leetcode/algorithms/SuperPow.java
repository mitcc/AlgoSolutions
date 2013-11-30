/*
 * Your task is to calculate ab mod 1337 where a 
 * is a positive integer and b is an extremely 
 * large positive integer given in the form of an
 * array.

 * Example1:
 * 
 * a = 2
 * b = [3]
 * 
 * Result: 8
 * Example2:
 * 
 * a = 2
 * b = [1,0]
 * 
 * Result: 1024
 */
public class SuperPow {

    public static final int mod = 1337;

    public int superPow(int a, int[] b) {
        int result = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            result = result * pow(a, b[i]) % mod;
            a = pow(a, 10);
        }
        return result;
    }

    public int pow(int a, int n) {
        int result = 1;
        for (a %= mod; n != 0; n >>= 1, a = a * a % mod) {
            if ((n & 1) != 0) {
                result = result * a % mod;
            }
        }
        return result;
    }

}
