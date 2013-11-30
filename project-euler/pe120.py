'''
Square remainders
Problem 120

Let r be the remainder when (a - 1)^n + (a + 1)^n is divided by a^2.
For example, if a = 7 and n = 3, then r = 42: 6^3 + 8^3 = 728, 728 % 49 = 42.
And as n varies, so too will r, but for a = 7 it turns out that rMax = 42.

For 3 <= a <= 1000, find ∑ rMax.
'''

__author__ = 'SUN'

if __name__ == '__main__':
    res = 0
    for i in range(3, 1001):
        res += i * i - i
        if i % 2 == 0:
            res -= i
    print(res)