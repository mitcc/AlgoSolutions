'''
Problem 112
Working from left-to-right if no digit is exceeded by the digit to its left it
is called an increasing number; for example, 134468.

Similarly if no digit is exceeded by the digit to its right it is called a
decreasing number; for example, 66420.

We shall call a positive integer that is neither increasing nor decreasing a
"bouncy" number; for example, 155349.

Clearly there cannot be any bouncy numbers below one-hundred, but just over
half of the numbers below one-thousand (525) are bouncy. In fact, the least
number for which the proportion of bouncy numbers first reaches 50% is 538.

Surprisingly, bouncy numbers become more and more common and by the time we
reach 21780 the proportion of bouncy numbers is equal to 90%.

Find the least number for which the proportion of bouncy numbers is exactly 99%.
'''
__author__ = 'SUN'

def is_bouncy(n):
    is_increase = True
    is_decrease = True
    while n >= 10:
        if is_increase and n % 10 < (n // 10 % 10):
            is_increase = False
        if is_decrease and n % 10 > (n // 10 % 10):
            is_decrease = False
        n //= 10
    return not is_increase and not is_decrease

if __name__ == '__main__':
    cnt = 0
    i = 1
    while True:
        if is_bouncy(i):
            cnt += 1
        if 99 * i == 100 * cnt:
            break
        i += 1
    print(i)