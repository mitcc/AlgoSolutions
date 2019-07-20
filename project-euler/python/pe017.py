'''
Number letter counts
Problem 17
If the numbers 1 to 5 are written out in words: one, two, three, four,
five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were
written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred
and forty-two) contains 23 letters and 115 (one hundred and fifteen)
contains 20 letters. The use of "and" when writing out numbers is in
compliance with British usage.
'''

__date__ = '14-2-18'
__author__ = 'SUN'

def letter_count(n):
    units = [3, 3, 5, 4, 4, 3, 5, 5, 4]
    teens = [3, 6, 6, 8, 8, 7, 7, 9, 8, 8]
    tys = [6, 6, 5, 5, 5, 7, 6, 6]
    cnt = 0
    if n // 100 % 10 > 0:
        cnt += units[n // 100 - 1] + 7
    if n % 100 > 0:
        if n // 100 > 0:
            cnt += 3
        if n % 100 // 10 == 1:
            cnt += teens[n % 100 - 10]
        if n % 100 // 10 != 1:
            if n % 100 // 10 > 1:
                cnt += tys[n % 100 // 10 - 2]
            if n % 10 > 0:
                cnt += units[n % 10 - 1]
    if n == 1000:
        cnt = 11
    return cnt

if __name__ == '__main__':
    print(sum(letter_count(i) for i in range(1, 1001)))