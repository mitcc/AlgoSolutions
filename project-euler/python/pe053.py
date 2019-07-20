'''
Combinatoric selections
Problem 53

There are exactly ten ways of selecting three from five, 12345: 123, 124, 125,
134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, 5C3 = 10.

In general,

nCr =	n!/(r!(n−r)!), where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater
than one-million?
'''
__author__ = 'SUN'

def combination(n, r):
    c = 1
    for i in range(1, r + 1):
        c = c * (n + 1 - i) // i
    return c

if __name__ == '__main__':
    cnt = 0
    for n in range(1, 101):
        if combination(n, n // 2) > 1000000:
            r = n // 2
            while combination(n, r) > 1000000:
                r -= 1
            cnt += n - 2 * r - 1
    print(cnt)