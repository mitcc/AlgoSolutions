'''
Sum of squares of divisors
Problem 401
The divisors of 6 are 1,2,3 and 6.
The sum of the squares of these numbers is 1+4+9+36=50.

Let sigma2(n) represent the sum of the squares of the divisors of n. Thus
sigma2(6)=50.

Let SIGMA2 represent the summatory function of sigma2, that is SIGMA2(n)=
∑sigma2(i) for i=1 to n.
The first 6 values of SIGMA2 are: 1,6,16,37,63 and 113.
Find SIGMA2(10^15) modulo 10^9.
'''

__date__ = '14-2-21'
__author__ = 'SUN'

import time

def pyramidal(n):
    return n * (n + 1) * (2 * n + 1) // 6

if __name__ == '__main__':
    start = time.clock()
    N = 10 ** 15
    res = 0
    i = 1
    while i <= N:
        divisor = N // i
        repeat = N // divisor - i + 1
        res = (res + repeat * pyramidal(divisor)) % 10 ** 9
        i += repeat
    print(res)
    print(time.clock() - start)