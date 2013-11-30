import time

__author__ = 'SUN'

'''
A palindromic number reads the same both ways. The largest palindrome
made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
'''

def largest_product_palindrome(start, end):
    result = 0
    for i in range(end, start - 1, -1):
        for j in range(end, i - 1, -1):
            product = i * j
            if str(product) == str(product)[::-1] and product > result:
                result = product
    return result

if __name__ == '__main__':
    start = time.clock()
    print(largest_product_palindrome(100, 999))
    print('Runtime is', time.clock() - start)
