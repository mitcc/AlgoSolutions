"""
Pandigital prime
Problem 41
We shall say that an n-digit number is pandigital if it makes use of all the
digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
also prime.

What is the largest n-digit pandigital prime that exists?
"""
import time

__date__ = '14-3-22'
__author__ = 'SUN'

if __name__ == '__main__':
    start = time.clock()
    N = 7654321
    prime = [True] * (N + 1)
    prime[0] = prime[1] = False
    for i in range(2, int(N ** 0.5) + 1):
        if prime[i]:
            for j in range(i * i, N + 1, i):
                prime[j] = False
    for i in range(7654321, 0, -1):
        if prime[i] and sorted(str(i)) == (['1', '2', '3', '4', '5', '6', '7']
                                           or ['1', '2', '3', '4']):
            print(i)
            break
    print('Runtime is ', time.clock() - start)