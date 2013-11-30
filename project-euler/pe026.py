'''
Reciprocal cycles
Problem 26
A unit fraction contains 1 in the numerator. The decimal representation of the
unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle
in its decimal fraction part.
'''
__date__ = '14-3-12'
__author__ = 'SUN'

def reciprocal(d):
    re = []
    n = 1
    while True:
        re.append(n)
        n = 10 * n % d
        if n == 0:
            return 0
        elif n in re:
            return len(re) - re.index(n)

if __name__ == '__main__':
    res = 0
    cnt = 0
    for d in range(2, 1000):
        if cnt < reciprocal(d):
            cnt = reciprocal(d)
            res = d
    print(res)