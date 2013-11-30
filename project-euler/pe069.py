"""
Totient maximum
Problem 69
Euler's Totient function, φ(n) [sometimes called the phi function], is used to
determine the number of numbers less than n which are relatively prime to n.
For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively
prime to nine, φ(9)=6.

n	Relatively Prime	φ(n)	 n/φ(n)
2	1	                  1	       2
3	1,2	                  2        1.5
4	1,3	                  2	       2
5	1,2,3,4	              4	       1.25
6	1,5	                  2	       3
7	1,2,3,4,5,6	          6	       1.1666...
8	1,3,5,7	              4	       2
9	1,2,4,5,7,8	          6	       1.5
10	1,3,7,9	              4	       2.5
It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.

Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
"""
import time

__date__ = '14-4-4'
__author__ = 'SUN'

def prime_sieve(limit):
    is_prime = [True] * (limit + 1)
    is_prime[0] = is_prime[1] = False
    for i in range(2, int(limit ** 0.5) + 1):
        if is_prime[i]:
            for j in range(i ** 2, limit + 1, i):
                is_prime[j] = False
    prime = []
    for i in range(limit + 1):
        if is_prime[i]:
            prime.append(i)
    return prime

if __name__ == '__main__':
    start = time.clock()
    N = 1000000
    prime = prime_sieve(30)
    answer = 1
    for x in prime:
        if answer * x > N:
            break
        answer *= x
    print(answer)
    print('Runtime is ', time.clock() - start)