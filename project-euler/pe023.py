'''
Non-abundant sums
Problem 23

A perfect number is a number for which the sum of its proper divisors is exactly
equal to the number. For example, the sum of the proper divisors of 28 would be
1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n
and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
number that can be written as the sum of two abundant numbers is 24. By
mathematical analysis, it can be shown that all integers greater than 28123 can
be written as the sum of two abundant numbers. However, this upper limit cannot
be reduced any further by analysis even though it is known that the greatest
number that cannot be expressed as the sum of two abundant numbers is less than
this limit.

Find the sum of all the positive integers which cannot be written as the sum of
two abundant numbers.
'''
__author__ = 'SUN'

def is_abundant(n):
    s = 0
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            s += i + n // i
    if int(n ** 0.5) ** 2 == n:
        s -= int(n ** 0.5)
    return s > n


if __name__ == '__main__':
    a = []
    for i in range(28124):
        a.append(is_abundant(i))
    res = 0
    for i in range(28124):
        for j in range(i):
            if a[j] and a[i - j]:
                break
            if j == i - 1:
                res += i
                break
    print(res)