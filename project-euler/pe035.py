'''
Circular primes
Problem 35
The number, 197, is called a circular prime because all rotations of the
digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
73, 79, and 97.

How many circular primes are there below one million?
'''

__date__ = '14-3-18'
__author__ = 'SUN'

if __name__ == '__main__':
    N = 1000000
    num = [True] * N
    num[0] = num[1] = False
    for i in range(2, int(N ** 0.5) + 1):
        if num[i]:
            for j in range(i * i, N, i):
                num[j] = False
    cnt = 0
    for i in range(N):
        if num[i]:
            temp = i
            n = 1
            for j in range(len(str(i)) - 1):
                temp = temp % (10 ** (len(str(i)) - 1)) * 10 + temp // (10 ** (len(str(i)) - 1))
                if num[temp]:
                    n += 1
                else:
                    break
            if n == len(str(i)):
                cnt += 1
    print(cnt)