"""
Totient permutation
Problem 70
Euler's Totient function, φ(n) [sometimes called the phi function], is used to
determine the number of positive numbers less than or equal to n which are
relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than
nine and relatively prime to nine, φ(9)=6.
The number 1 is considered to be relatively prime to every positive number, so
φ(1)=1.

Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation
of 79180.

Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the
ratio n/φ(n) produces a minimum.
"""
import time
from pe069 import prime_sieve

__date__ = '14-4-5'
__author__ = 'SUN'

def totient(n):
    phi = 1
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            while n % i == 0:
                phi *= i
                n //= i
            phi = phi // i * (i - 1)
    if n > 1:
        phi *= n - 1
    return phi

def totient_array(n):
    array = [x for x in range(n + 1)]
    for i in range(2, n + 1):
        if array[i] == i:
            for j in range(i, n + 1, i):
                array[j] = array[j] // i * (i - 1)
    return array


if __name__ == '__main__':
    start = time.clock()
    N = 10000000
    prime = prime_sieve(4000)
    answer = 0
    ratio = 3
    for i in range(len(prime)):
        for j in range(i, len(prime)):
            phi = prime[i] * prime[j]
            if phi > N:
                break
            if sorted(str((prime[i] - 1) * (prime[j] - 1))) == sorted(str(phi)) \
                and ratio > phi / ((prime[i] - 1) * (prime[j] - 1)):
                answer = phi
                ratio = phi / ((prime[i] - 1) * (prime[j] - 1))
    print(answer)
    print('Runtime is ', time.clock() - start)