"""
Convergents of e
Problem 65
The square root of 2 can be written as an infinite continued fraction
The infinite continued fraction can be written, √2 = [1;(2)], (2) indicates
that 2 repeats ad infinitum. In a similar way, √23 = [4;(1,3,1,8)].

It turns out that the sequence of partial values of continued fractions for
square roots provide the best rational approximations. Let us consider the
convergents for √2.


The sequence of the first ten convergents for √2 are:

1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
What is most surprising is that the important mathematical constant,
e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].

The first ten terms in the sequence of convergents for e are:

2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.

Find the sum of digits in the numerator of the 100th convergent of the
continued fraction for e.
"""
__date__ = '14-4-2'
__author__ = 'SUN'

def calculate(k):
    if k < 1:
        return None
    if k == 1:
        return 2, 1
    n = 1
    d = 2 * k // 3 if k % 3 == 0 else 1
    for i in range(k - 1, 1, -1):
        x = 2 * i // 3 if i % 3 == 0 else 1
        n, d = d, x * d + n
    n += 2 * d
    return n, d

if __name__ == '__main__':
    print(sum(int(c) for c in str(calculate(100)[0])))