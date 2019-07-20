"""
Palindromic sums
Problem 125
The palindromic number 595 is interesting because it can be written as the sum
of consecutive squares: 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.

There are exactly eleven palindromes below one-thousand that can be written as
consecutive square sums, and the sum of these palindromes is 4164. Note that
1 = 0^2 + 1^2 has not been included as this problem is concerned with the squares
of positive integers.

Find the sum of all the numbers less than 10^8 that are both palindromic and can
be written as the sum of consecutive squares.
"""
import time

__date__ = '14-4-25'
__author__ = 'SUN'

if __name__ == '__main__':
    start = time.clock()
    N = 100000000
    sq = [x ** 2 for x in range(1, int(N ** 0.5) + 1)]
    res = 0
    palin = []
    for i in range(len(sq)):
        for j in range(i + 2, len(sq)):
            s = sum(sq[i:j])
            if s >= N:
                break
            if str(s) == str(s)[::-1] and s not in palin:
                palin.append(s)
                res += s
    print(res)
    print('Runtime is', time.clock() - start)