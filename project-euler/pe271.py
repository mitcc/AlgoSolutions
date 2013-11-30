'''
Modular Cubes, part 1
Problem 271
For a positive number n, define S(n) as the sum of the integers x, for which 1<x<n and
x^3≡1 mod n.

When n=91, there are 8 possible values for x, namely : 9, 16, 22, 29, 53, 74, 79, 81.
Thus, S(91)=9+16+22+29+53+74+79+81=363.

Find S(13082761331670030).
'''
__date__ = '14-3-2'
__author__ = 'SUN'

import time

def s(n):
    c = []
    for i in range(1, n):
        if i ** 3 % n == 1:
            c.append(i)
    return c

def get_prime_factor(n):
    c = []
    i = 2
    while n > 1:
        if n % i == 0:
            while n % i == 0:
                c.append(i)
                n //= i
        i += 1
    return c

if __name__ == '__main__':
    start = time.clock()
    N = 13082761331670030
    res = 0
    factor = get_prime_factor(N)
    single_product= 1
    multiple = {}
    for x in factor:
        if len(s(x)) == 1:
            single_product *= x
        else:
            multiple[x] = s(x)

    k = 1
    candidate = single_product * k + 1
    while candidate < N:
        flag = True
        for x in multiple:
            flag = flag and multiple[x].__contains__(candidate % x)
        if flag:
            res += candidate
        k += 1
        candidate = single_product * k + 1
    print(res)
    print('Runtime is ', time.clock() - start)