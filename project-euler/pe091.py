"""
Right triangles with integer coordinates
Problem 91
The points P (x1, y1) and Q (x2, y2) are plotted at integer co-ordinates and
are joined to the origin, O(0,0), to form ΔOPQ.


There are exactly fourteen triangles containing a right angle that can be
formed when each co-ordinate lies between 0 and 2 inclusive; that is,
0 ≤ x1, y1, x2, y2 ≤ 2.


Given that 0 ≤ x1, y1, x2, y2 ≤ 50, how many right triangles can be formed?
"""
import time

__date__ = '14-4-16'
__author__ = 'SUN'

if __name__ == '__main__':
    start = time.clock()
    N = 50
    answer = N * N
    for x1 in range(N + 1):
        for y1 in range(N + 1):
            for x2 in range(N + 1):
                for y2 in range(N + 1):
                    if x1 == 0 and y1 == 0 or x2 == 0 and y2 == 0:
                        continue
                    if x1 ** 2 + y1 ** 2 - x1 * x2 - y1 * y2 == 0 and (x1 != x2 or y1 != y2):
                        answer += 1
    print(answer)
    print('Runtime is', time.clock() - start)