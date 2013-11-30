"""
Digit power sum
Problem 119
The number 512 is interesting because it is equal to the sum of its digits
raised to some power: 5 + 1 + 2 = 8, and 83 = 512. Another example of a number
with this property is 614656 = 284.

We shall define an to be the nth term of this sequence and insist that a number
must contain at least two digits to have a sum.

You are given that a2 = 512 and a10 = 614656.

Find a30.
"""
import time

__date__ = '14-4-23'
__author__ = 'SUN'

def digit_sum(n):
    return sum(map(int, str(n)))

if __name__ == '__main__':
    start = time.clock()
    array = []
    for base in range(2, 100):
        for e in range(2, 30):
            p = base ** e
            if digit_sum(p) == base:
                array.append(p)
    print(sorted(array)[29])
    print('Runtime is', time.clock() - start)
