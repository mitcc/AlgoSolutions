"""
Prime square remainders
Problem 123
Let pn be the nth prime: 2, 3, 5, 7, 11, ..., and let r be the remainder when
(pn−1)^n + (pn+1)^n is divided by pn^2.

For example, when n = 3, p3 = 5, and 4^3 + 6^3 = 280 ≡ 5 mod 25.

The least value of n for which the remainder first exceeds 10^9 is 7037.

Find the least value of n for which the remainder first exceeds 10^10.
"""
import time
from pe069 import prime_sieve

__date__ = '14-4-24'
__author__ = 'SUN'

if __name__ == '__main__':
    start = time.clock()
    prime = prime_sieve(300000)
    for i in range(0, len(prime), 2):
        if 2 * (i + 1) * prime[i] % prime[i] ** 2 > 10000000000:
            print(i + 1)
            break
    print('Runtime is', time.clock() - start)