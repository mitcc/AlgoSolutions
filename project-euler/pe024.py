'''
Lexicographic permutations
Problem 24
A permutation is an ordered arrangement of objects. For example, 3124 is one
possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
are listed numerically or alphabetically, we call it lexicographic order. The
lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5,
6, 7, 8 and 9?
'''

__date__ = '14-3-11'
__author__ = 'SUN'

def factor(n):
    f = 1
    for i in range(2, n + 1):
        f *= i
    return f

def get_permutation(array, k):
    per = ''
    n = len(array)
    f = factor(n)
    while n > 0:
        f //= n
        per += str(array[k // f])
        array = array[0:(k // f)] + array[(k // f + 1):len(array)]
        k = k % f
        n -= 1
    return per

if __name__ == '__main__':
    print(get_permutation([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], 999999))