'''
Amicable numbers
Problem 21
Let d(n) be defined as the sum of proper divisors of n (numbers less than n
which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and
each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55
and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and
142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
'''
__author__ = 'SUN'

def divisor_sum(n):
    if n == 0 or n == 1:
        return 0
    res = 1
    for i in range(2, int(n ** 0.5)):
        if n % i == 0:
            res += i + n // i
    if int(n ** 0.5) ** 2 == n:
        res += int(n ** 0.5)
    return res

def d(n):
    return n != divisor_sum(n) and n == divisor_sum(divisor_sum(n))

if __name__ == '__main__':
    res = 0
    for i in range(10000):
        if d(i):
            res += i
    print(res)