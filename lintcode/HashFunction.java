/*
 * In data structure Hash, hash function is used to convert a string
 * (or any other type) into an integer smaller than hash size and 
 * bigger or equal to zero. The objective of designing a hash 
 * function is to "hash" the key as unreasonable as possible. A good 
 * hash function can avoid collision as less as possible. A widely 
 * used hash function algorithm is using a magic number 33, consider 
 * any string as a 33 based big integer like follow:

hashcode("abcd") = 
        (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE 

                 = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE

                 = 3595978 % HASH_SIZE

here HASH_SIZE is the capacity of the hash table (you can assume a 
hash table is like an array with index 0 ~ HASH_SIZE-1).

Given a string as a key and the size of hash table, return the hash 
value of this key.f

Clarification
For this problem, you are not necessary to design your own hash 
algorithm or consider any collision issue, you just need to implement 
the algorithm as described.

Example
For key="abcd" and size=100, return 78
 */
public class HashFunction {
 
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        long hash = 0;
        for (int ch : key) {
            hash = (33 * hash % HASH_SIZE + ch % HASH_SIZE) % HASH_SIZE;
        }
        return (int) hash;
    }

/*****************************************************************************/

    public int hashCode(char[] key, int HASH_SIZE) {
        long hash = 0;
        for (int i = 0; i < key.length; ++i) {
            hash = (hash + key[i] * powMod(33, key.length - 1 - i, 
                        HASH_SIZE) % HASH_SIZE) % HASH_SIZE;
        }
        return (int) hash;
    }

    public long powMod(int base, int exp, int mod) {
        if (exp == 0) {
            return 1 % mod;
        }
        long half = powMod(base, exp / 2, mod);
        if (exp % 2 == 0) {
            return half * half % mod;
        } else {
            return (half * half % mod) * (base % mod) % mod;
        }
    }

/*****************************************************************************/

    // TLE
    public int hashCode(char[] key, int HASH_SIZE) {
        BigInteger hash = BigInteger.ZERO;
        int n = key.length;
        for (int i = 0; i < n; ++i) {
            BigInteger pow = BigInteger.valueOf(33).pow(n - i - 1);
            hash = hash.add(BigInteger.valueOf((int) key[i])
                    .multiply(pow)).mod(BigInteger.valueOf(HASH_SIZE));
        }
        return hash.intValue();
    }
    
}
