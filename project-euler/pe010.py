'''
Summation of primes
Problem 10
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.
'''

import time
from pe069 import prime_sieve

__author__ = 'SUN'

if __name__ == '__main__':
    start = time.clock()
    print(sum(prime_sieve(2000000)))
    print('Runtime is', time.clock() - start)