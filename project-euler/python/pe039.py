'''
Integer right triangles
Problem 39
If p is the perimeter of a right angle triangle with integral length sides, {a,
b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
'''
import math
import time

__date__ = '14-3-21'
__author__ = 'SUN'

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def project_euler_1(limit):
    res = 0
    cnt = 0
    for k in range(12, 1001):
        n = 0
        for i in range(1, int(k * (1 - math.sqrt(2) / 2))):
            for j in range(int(k * (1 - math.sqrt(2) / 2)), k // 2):
                if i ** 2 + j ** 2 == (k - i - j) ** 2:
                    n += 1
        if cnt < n:
            res = k
            cnt = n
    print(res)

def project_euler_2(limit):
    t = [0] * (limit + 1)
    for i in range(2, int((limit // 2) ** 0.5)):
        for j in range(1, i):
            if (i - j) % 2 == 1 and gcd(i, j) == 1:
                s = 2 * i * (i + j)
                for x in range(s, limit + 1, s):
                    t[x] += 1
    print(t.index(max(t)))

if __name__ == '__main__':
    start = time.clock()
    project_euler_2(1000)
    print('Runtime is ', time.clock() - start)