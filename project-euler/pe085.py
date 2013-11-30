'''
Counting rectangles
Problem 85

By counting carefully it can be seen that a rectangular grid measuring 3 by 2
contains eighteen rectangles:
	http://projecteuler.net/problem=85
Although there exists no rectangular grid that contains exactly two million
rectangles, find the area of the grid with the nearest solution.
'''
__author__ = 'SUN'

if __name__ == '__main__':
    res, m, n = 0, 0, 0
    for i in range(1, int(2000000 ** 0.5)):
        for j in range(i, int(2000000 ** 0.5)):
            s = i * (i + 1) * j * (j + 1) // 4
            if abs(res - 2000000) > abs(s - 2000000):
                res, m, n = s, i, j
    print("m = ", m, ", n = ", n, ", solution = ", res)