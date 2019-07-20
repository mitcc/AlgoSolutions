'''
Pandigital multiples
Problem 38
Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. We will
call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and
5, giving the pandigital, 918273645, which is the concatenated product of 9 and
(1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the
concatenated product of an integer with (1,2, ... , n) where n > 1?
'''
__date__ = '14-3-20'
__author__ = 'SUN'

if __name__ == '__main__':
    res = 0
    for i in range(10000):
        s = str(i)
        k = 2
        while len(s) < 9:
            s += str(i * k)
            k += 1
        if sorted(s) == ['1', '2', '3', '4', '5', '6', '7', '8', '9'] and res < int(s):
            res = int(s)
            print('i = ', i, '( 1, ..., ', k - 1, ')', 'multiples = int(s)')
    print(res)