'''
Amicable chains
Problem 95

The proper divisors of a number are all the divisors excluding the number itself.
For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. As the sum of
these divisors is equal to 28, we call it a perfect number.

Interestingly the sum of the proper divisors of 220 is 284 and the sum of the
proper divisors of 284 is 220, forming a chain of two numbers. For this reason,
220 and 284 are called an amicable pair.

Perhaps less well known are longer chains. For example, starting with 12496, we
form a chain of five numbers:

12496 → 14288 → 15472 → 14536 → 14264 (→ 12496 → ...)

Since this chain returns to its starting point, it is called an amicable chain.

Find the smallest member of the longest amicable chain with no element exceeding
one million.
'''

__author__ = 'SUN'

if __name__ == '__main__':
    n = 1000000
    sum_divisor = [1] * (n + 1)
    for i in range(2, n // 2 + 1):
        j = 2 * i
        while j < n:
            sum_divisor[j] += i
            j += i

    res = []
    for i in range(n):
        chain = []
        while i <= n and not chain.__contains__(i):
            chain.append(i)
            i = sum_divisor[i]
        if i <= n and i == chain[0] and len(res) < len(chain):
            res = chain
    print(min(res))