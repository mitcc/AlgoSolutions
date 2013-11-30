'''
Powerful digit sum
Problem 56
A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100
is almost unimaginably large: one followed by two-hundred zeros. Despite their
size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, a^b, where a, b < 100, what is the
maximum digital sum?
'''

__author__ = 'SUN'

if __name__ == '__main__':
    res = 0
    for i in range(100, 0, -1):
        for j in range(100, 0, -1):
            n = i ** j
            tempSum = 0
            while n > 0:
                tempSum += n % 10
                n //= 10
            res = max(res, tempSum)
    print(res)