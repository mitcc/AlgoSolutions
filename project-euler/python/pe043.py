"""
Sub-string divisibility
Problem 43
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of
each of the digits 0 to 9 in some order, but it also has a rather interesting
sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note
the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.
"""
import time

__date__ = '14-3-24'
__author__ = 'SUN'

def pandigital(s):
    pan = ['']
    for c in s:
        temp = []
        for word in pan:
            for i in range(len(word) + 1):
                temp.append(word[0:i] + c + word[i:])
        pan = temp
    return pan

def is_divisible(s):
    prime = [2, 3, 5, 7, 11, 13, 17]
    for i in range(7):
        if int(s[i+1:i+4]) % prime[i] != 0:
            return False
    return True

if __name__ == '__main__':
    start = time.clock()
    p = pandigital('0123456789')
    res = 0
    print(sum(int(word) for word in p if is_divisible(word)))
    print('Runtime is ', time.clock() - start)