__author__ = 'SUN'

'''
2520 is the smallest number that can be divided by each
of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly
divisible by all of the numbers from 1 to 20?
'''

def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)

def lcm(a, b):
    return a * b // gcd(a, b)

def lcm_result(start, end):
    if start > end:
        start, end = end, start
    elif start == end:
        return start
    else:
        return lcm(start, lcm_result(start + 1, end))

if __name__ == '__main__':
    print(pow(2, 4) * pow(3, 2) * 5 * 7 * 11 * 13 * 17 * 19)
    print(lcm_result(1, 20))