/*
Your task is to calculate ab mod 1337 where a is a positive integer and b is an
extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
 */
public class SuperPow {

    public int superPow(int a, int[] b) {
        int result = 1;
        int mod = 1337;
        for (int i = 0, base = a; i < b.length; ++i) {
            result = result * pow(base, b[b.length - 1 - i], mod) % mod;
            base = pow(base, 10, mod);
        }
        return result;
    }

    public int pow(int a, int exp, int mod) {
        int result = 1;
        for (a %= mod; exp != 0; a = a * a % mod, exp >>= 1) {
            if ((exp & 1) != 0) {
                result = result * a % mod;
            }
        }
        return result;
    }

}
