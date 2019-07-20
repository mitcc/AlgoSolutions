'''
Pandigital products
Problem 32
We shall say that an n-digit number is pandigital if it makes use of all the
digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through
5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can
be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only
include it once in your sum.
'''

__date__ = '14-3-14'
__author__ = 'SUN'

if __name__ == '__main__':
    res = []
    for i in range(1, 10):
        for j in range(1000, 10000):
            s = str(i) + str(j) + str(i * j)
            if '0' not in s and len(list(s)) == len(set(s)) == 9 and i * j not in res:
                res.append(i * j)
    for i in range(10, 100):
        for j in range(100, 1000):
            s = str(i) + str(j) + str(i * j)
            if '0' not in s and len(list(s)) == len(set(s)) == 9 and i * j not in res:
                res.append(i * j)
    print(sum(res))