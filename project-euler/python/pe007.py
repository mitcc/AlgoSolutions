'''
10001st prime
Problem 7
By listing the first six prime numbers: 2, 3,
5, 7, 11, and 13, we can see that the 6th prime
is 13. What is the 10 001st prime number?
'''
from pe069 import prime_sieve

__author__ = 'SUN'

if __name__ == '__main__':
    print(prime_sieve(150000)[10000])