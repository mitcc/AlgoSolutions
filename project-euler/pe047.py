'''
Distinct primes factors
Problem 47

The first two consecutive numbers to have two distinct prime factors are:
                     14 = 2 × 7
                     15 = 3 × 5
The first three consecutive numbers to have three distinct prime factors are:

                      644 = 2² × 7 × 23
                      645 = 3 × 5 × 43
                      646 = 2 × 17 × 19.
Find the first four consecutive integers to have four distinct prime factors.
What is the first of these numbers?
'''
__author__ = 'SUN'

def distinct_prime_factor(n):
    cnt = 0
    start = 2
    end = int(n ** 0.5)
    while start <= end:
        if n % start == 0:
            cnt += 1
            while n % start == 0:
                n //= start
        start += 1
        end = int(n ** 0.5)
    if n > 1:
        cnt += 1
    return cnt

if __name__ == '__main__':
    i = 2
    while not distinct_prime_factor(i) == distinct_prime_factor(i + 1) == distinct_prime_factor(i + 2) == distinct_prime_factor(i + 3) == 4:
        i += 1
    print(i)