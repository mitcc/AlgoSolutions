'''
Digit factorials
Problem 34
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their
digits.

Note: as 1! = 1 and 2! = 2 are not sums thetemp are not included.
'''
__date__ = '14-3-17'
__author__ = 'SUN'

import time

if __name__ == '__main__':
    start = time.clock()
    factorial = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880]
    n = 1
    while n * factorial[9] >= 10 ** n - 1:
        n += 1
    res = 0
    for x in range(10, 10 ** n):
        s = 0
        temp = x
        while temp > 0:
            s += factorial[temp % 10]
            temp //= 10
        if s == x:
            print(x)
            res += s
    print(res)
    print('Runtime is ', time.clock() - start)
