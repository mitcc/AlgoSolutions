'''
Counting block combinations I
Problem 114

http://projecteuler.net/problem=114

A row measuring seven units in length has red blocks with a minimum length of
three units placed on it, such that any two red blocks (which are allowed to be
different lengths) are separated by at least one black square.
There are exactly seventeen ways of doing this.

How many ways can a row measuring fifty units in length be filled?

NOTE: Although the example above does not lend itself to the possibility, in
general it is permitted to mix block sizes. For example, on a row measuring
eight units in length you could use red (3), black (1), and red (4).
'''

__date__ = '14-2-16'
__author__ = 'SUN'

def f(m, n):
    ways = [0] * (n + 1)
    for i in range(m):
        ways[i] = 1
    for i in range(m,n + 1):
        ways[i] += ways[i - 1] + 1
        for j in range(m, i):
            ways[i] += ways[i - j - 1]
    return ways[n]

if __name__ == '__main__':
    print(f(3, 50))