'''
Non-bouncy numbers
Problem 113
Working from left-to-right if no digit is exceeded by the digit to its left it
is called an increasing number; for example, 134468.

Similarly if no digit is exceeded by the digit to its right it is called a
decreasing number; for example, 66420.

We shall call a positive integer that is neither increasing nor decreasing a
"bouncy" number; for example, 155349.

As n increases, the proportion of bouncy numbers below n increases such that
there are only 12951 numbers below one-million that are not bouncy and only
277032 non-bouncy numbers below 10^10.

How many numbers below a googol (10^100) are not bouncy?
'''
__date__ = '14-2-28'
__author__ = 'SUN'

def combination(m, n):
    c = 1
    for i in range(1, m + 1):
        c = c * (n - i + 1) // i
    return c

if __name__ == '__main__':
    N = 100
    print(combination(9, N + 9) + combination(10, N + 10) - 10 * N - 2)