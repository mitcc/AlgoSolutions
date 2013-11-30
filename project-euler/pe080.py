"""
Square root digital expansion
Problem 80
It is well known that if the square root of a natural number is not an integer,
then it is irrational. The decimal expansion of such square roots is infinite
without any repeating pattern at all.

The square root of two is 1.41421356237309504880..., and the digital sum of
the first one hundred decimal digits is 475.

For the first one hundred natural numbers, find the total of the digital sums
of the first one hundred decimal digits for all the irrational square roots.
"""
from decimal import Decimal, getcontext

__date__ = '14-4-12'
__author__ = 'SUN'

if __name__ == '__main__':
    getcontext().prec = 102
    res = 0
    for i in range(1, 101):
        if Decimal(i).sqrt() % 1 != 0:
            res += sum(int(c) for c in str(Decimal(i).sqrt() * 10 ** 100)[:100])
    print(res)