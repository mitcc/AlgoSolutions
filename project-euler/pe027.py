'''
Quadratic primes
Problem 27
Euler discovered the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values
n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible
by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes
for the consecutive values n = 0 to 79. The product of the coefficients, −79 and
1601, is −126479.

Considering quadratics of the form:

n² + an + b, where |a| < 1000 and |b| < 1000

where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |−4| = 4
Find the product of the coefficients, a and b, for the quadratic expression that
produces the maximum number of primes for consecutive values of n, starting with
n = 0.
'''

__date__ = '14-3-13'
__author__ = 'SUN'
import time

def is_prime(n):
    if n == 0 or n == 1:
        return False
    if n % 2 == 2 or n % 3 == 0 or n % 5 == 0 or n % 7 == 0:
        return n == 2 or n == 3 or n == 5 or n == 7
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True

def quadratic_prime_length(a, b):
    k = 0
    if k ** 2 + k * a + b <= 1:
        return 0
    while k ** 2 + k * a + b > 1 and is_prime(k ** 2 + k * a + b):
        k += 1
    return k

if __name__ == '__main__':
    start = time.time()
    a = 0
    b = 0
    cnt = 0
    for i in range(-999, 1000):
        for j in range(-999, 1000):
            if quadratic_prime_length(i, j ) > cnt:
                cnt = quadratic_prime_length(i, j)
                a = i
                b = j
    print('a = ', a, ', b = ', b, ', a * b = ', a * b, ', cnt = ', cnt)
    print('Runtime is ', time.time() - start)