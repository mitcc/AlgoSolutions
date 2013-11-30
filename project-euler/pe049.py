'''
Prime permutations
Problem 49
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases
by 3330, is unusual in two ways: (i) each of the three terms are prime, and,
(ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this
sequence?
'''

__date__ = '14-2-20'
__author__ = 'SUN'

def number_array(n):
    array = []
    for i in range(len(str(n))):
        array.append(str(n)[i])
    return sorted(array)

if __name__ == '__main__':
    N = 10000
    prime = [True] * N
    prime[0] = prime[1] = False
    for i in range(2, int(N ** 0.5) + 1):
        if prime[i]:
            for j in range(i * i, N, i):
                prime[j] = False
    pp = []
    for i in range(1000, N):
        if prime[i]:
            pp.append(i)

    for i in range(len(pp)):
        for j in range(i + 1, len(pp)):
            if 2 * pp[j] - pp[i] >= 10000:
                break
            if prime[2 * pp[j] - pp[i]] and number_array(pp[i]) == \
                    number_array(pp[j]) == number_array(2 * pp[j] - pp[i]):
                print(pp[i], pp[j], 2 * pp[j] - pp[i])