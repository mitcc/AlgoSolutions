'''
Consecutive prime sum
Problem 50
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below
one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime,
contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most
consecutive primes?
'''

__date__ = '14-2-15'
__author__ = 'SUN'

if __name__ == '__main__':
    N = 1000000
    prime = [True] * (N)
    prime[0] = prime[1] = False
    for i in range(2, int(N ** 0.5) + 1):
        for j in range(i * i, N, i):
            prime[j] = False

    pp = []
    for i in range(N):
        if prime[i]:
            pp.append(i)

    s = 0
    cnt = 0
    for i in range(len(pp)):
        sum_of_prime = 0
        for j in range(i, len(pp)):
            if sum_of_prime + pp[j] >= N:
                break
            sum_of_prime += pp[j]
            if prime[sum_of_prime] and cnt < j - i + 1:
                s = sum_of_prime
                cnt = j - i + 1
    print(s)