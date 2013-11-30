'''
Singular integer right triangles
Problem 75
It turns out that 12 cm is the smallest length of wire that can be bent to form
an integer sided right angle triangle in exactly one way, but there are many
more examples.

12 cm: (3,4,5)
24 cm: (6,8,10)
30 cm: (5,12,13)
36 cm: (9,12,15)
40 cm: (8,15,17)
48 cm: (12,16,20)

In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer
sided right angle triangle, and other lengths allow more than one solution to be
found; for example, using 120 cm it is possible to form exactly three different
integer sided right angle triangles.

120 cm: (30,40,50), (20,48,52), (24,45,51)

Given that L is the length of the wire, for how many values of L ≤ 1,500,000 can
exactly one integer sided right angle triangle be formed?
'''

import time

__date__ = '14-3-8'
__author__ = 'SUN'

def gcd(m, n):
    while n != 0:
        m, n = n, m % n
    return m

def project_euler(limit):
    triangle = [0] * (limit + 1)
    for i in range(2, int((limit // 2) ** 0.5)):
        for j in range(1, i):
            if (i - j) % 2 == 1 and gcd(i, j) == 1:
                s = 2 * i * (i + j)
                for x in range(s, limit + 1, s):
                    triangle[x] += 1
    print(triangle.count(1))

if __name__ == '__main__':
    start = time.clock()
    project_euler(1500000)
    print('Runtime is ', time.clock() - start)