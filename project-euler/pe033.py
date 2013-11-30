'''
Digit canceling fractions
Problem 33
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in
attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is
correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than
one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find
the value of the denominator.
'''
__author__ = 'SUN'

def gcd(m, n):
    while m != 0:
        m, n = n % m, m
    return n

if __name__ == '__main__':
    numerator, denominator = 1, 1
    for i in range(10, 100):
        for j in range(10, i):
            if i % 10 != 0 and i % 10 != i // 10 and j % 10 == i // 10 and j / i == (j // 10) / (i % 10):
                print(j, "/", i, " = ", j // 10, "/", i % 10)
                numerator *= j
                denominator *= i
    denominator //= gcd(numerator, denominator)
    print("solution = ", denominator)
