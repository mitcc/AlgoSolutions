'''
Longest Collatz sequence
Problem 14
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains
10 terms. Although it has not been proved yet (Collatz Problem), it is thought
that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
'''

__date__ = '14-2-23'
__author__ = 'SUN'

import time

cache = [0] * 1000000

def collatz(n):
    if n == 1:
        return 1
    if n < len(cache) and cache[n] > 0:
        return cache[n]
    if n & 1 == 0:
        cnt = 1 + collatz(n >> 1)
    else:
        cnt = 2 + collatz((3 * n + 1) >> 1)
    if n < len(cache):
        cache[n] = cnt
    return cnt

if __name__ == '__main__':
    start = time.clock()
    res = 0
    max_length = 0
    for i in range(1, 1000000):
        collatz(i)
    for i in range(1, 1000000):
        if max_length < collatz(i):
            max_length = collatz(i)
            res = i
    print(res)
    print("Runtime is", time.clock() - start)