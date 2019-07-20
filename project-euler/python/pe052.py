"""
Permuted multiples
Problem 52
It can be seen that the number, 125874, and its double, 251748, contain exactly
the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
contain the same digits.
"""
import time

__date__ = '14-3-28'
__author__ = 'SUN'

if __name__ == '__main__':
    start = time.clock()
    x = 1
    while True:
        if sorted(str(x)) == sorted(str(2 * x)) == sorted(str(3 * x)) == \
                sorted(str(4 * x)) == sorted(str(5 * x)) == sorted(str(6 * x)):
            break
        x += 1
    print(x)
    print('Runtime is ', time.clock() - start)