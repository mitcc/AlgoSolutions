'''
If we list all the natural numbers below 10 that are multiples of 
3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
'''

__author__ = 'SUN'

import time

def calculate():
    count = sum(x for x in range(0, 1000, 3)) + \
            sum(x if x % 3 != 0 else 0 for x in range(0, 1000, 5))
    print(count)

if __name__ == '__main__':
    start = time.clock()
    calculate()
    print("Run time is", time.clock() - start)