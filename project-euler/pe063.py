"""
Powerful digit counts
Problem 63
The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit
number, 134217728=8^9, is a ninth power.

How many n-digit positive integers exist which are also an nth power?
"""
import math

__date__ = '14-3-31'
__author__ = 'SUN'

if __name__ == '__main__':
    count = 1 + sum(int(1 + 1 / (math.log(10, i) - 1)) for i in range(2, 10))
    print(count)