'''
Red, green or blue tiles
Problem 116
URL:http://projecteuler.net/problem=116
A row of five black square tiles is to have a number of its tiles replaced with
coloured oblong tiles chosen from red (length two), green (length three), or
blue (length four).

If red tiles are chosen there are exactly seven ways this can be done.

If green tiles are chosen there are three ways.

And if blue tiles are chosen there are two ways.

Assuming that colours cannot be mixed there are 7 + 3 + 2 = 12 ways of replacing
the black tiles in a row measuring five units in length.

How many different ways can the black tiles in a row measuring fifty units in
length be replaced if colours cannot be mixed and at least one coloured tile
must be used?
'''

__date__ = '14-2-17'
__author__ = 'SUN'

def f(m, n):
    ways = [0] * (n + 1)
    for i in range(m):
        ways[i] = 1
    for i in range(m, n + 1):
        ways[i] += ways[i - 1] + ways[i - m]
    return ways[n] - 1

if __name__ == '__main__':
    print(f(2, 50) + f(3, 50) + f(4, 50))