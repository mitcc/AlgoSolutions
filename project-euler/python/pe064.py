"""
Odd period square roots
Problem 64

For conciseness, we use the notation √23 = [4;(1,3,1,8)], to indicate that the
block (1,3,1,8) repeats indefinitely.

The first ten continued fraction representations of (irrational) square roots
are:

√2=[1;(2)], period=1
√3=[1;(1,2)], period=2
√5=[2;(4)], period=1
√6=[2;(2,4)], period=2
√7=[2;(1,1,1,4)], period=4
√8=[2;(1,4)], period=2
√10=[3;(6)], period=1
√11=[3;(3,6)], period=2
√12= [3;(2,6)], period=2
√13=[3;(1,1,1,1,6)], period=5

Exactly four continued fractions, for N ≤ 13, have an odd period.

How many continued fractions for N ≤ 10000 have an odd period?
"""
import time

__date__ = '14-4-1'
__author__ = 'SUN'

def get_square_root(n):
    root = []
    period = []
    cache = []
    x, y = 0, 1
    while (x + 1) ** 2 <= n:
        x += 1
    root.append(x)
    if x ** 2 != n:
        while (x, y) not in cache:
            cache.append((x, y))
            k = 0
            d = (n - x ** 2) // y
            while ((k + 1) * d - x) ** 2 <= n:
                k += 1
            period.append(k)
            x, y = k * d - x, d
    root.append(period)
    return root

if __name__ == '__main__':
    start = time.clock()
    N = 10000
    count = 0
    for i in range(N + 1):
        if len(get_square_root(i)[-1]) % 2 == 1:
            count += 1
    print(count)
    print('Runtime is ', time.clock() - start)