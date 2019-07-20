'''
Counting block combinations II
Problem 115
NOTE: This is a more difficult version of problem 114.

http://projecteuler.net/problem=115

A row measuring n units in length has red blocks with a minimum length of m
units placed on it, such that any two red blocks (which are allowed to be
different lengths) are separated by at least one black square.

Let the fill-count function, F(m, n), represent the number of ways that a row
can be filled.

For example, F(3, 29) = 673135 and F(3, 30) = 1089155.

That is, for m = 3, it can be seen that n = 30 is the smallest value for which
the fill-count function first exceeds one million.

In the same way, for m = 10, it can be verified that F(10, 56) = 880711 and
F(10, 57) = 1148904, so n = 57 is the least value for which the fill-count
function first exceeds one million.

For m = 50, find the least value of n for which the fill-count function first
exceeds one million.
'''

__date__ = '14-2-16'
__author__ = 'SUN'

def f(m, n):
    ways = [0] * (n + 1)
    for i in range(m):
        ways[i] = 1
    for i in range(m, n + 1):
        ways[i] += ways[i - 1] + 1
        for j in range(m, i):
            ways[i] += ways[i - j - 1]
    return ways[n]

if __name__ == '__main__':
    i = 50
    while f(50, i) <= 1000000:
        i += 1
    print(i)