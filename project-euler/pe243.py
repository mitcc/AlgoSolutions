"""
Resilience
Problem 243
A positive fraction whose numerator is less than its denominator is called a
proper fraction.
For any denominator, d, there will be d−1 proper fractions; for example, with
d = 12:
1/12 , 2/12 , 3/12 , 4/12 , 5/12 , 6/12 , 7/12 , 8/12 , 9/12 , 10/12 , 11/12 .

We shall call a fraction that cannot be cancelled down a resilient fraction.
Furthermore we shall define the resilience of a denominator, R(d), to be the
ratio of its proper fractions that are resilient; for example, R(12) = 4/11 .
In fact, d = 12 is the smallest denominator having a resilience R(d) < 4/10 .

Find the smallest denominator d, having a resilience R(d) < 15499/94744 .
"""
from pe069 import prime_sieve

__date__ = '14-4-19'
__author__ = 'SUN'

if __name__ == '__main__':
	prime = prime_sieve(30)
	n = 1
	d = 1
	for i in range(len(prime)):
		n *= prime[i] - 1
		d *= prime[i]
		for j in range(2, prime[i]):
			if n * j / (d * j - 1) < 15499 / 94744:
				print(d * j)
				exit(0)