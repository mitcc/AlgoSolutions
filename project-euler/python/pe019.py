'''
Counting Sundays
Problem 19

You are given the following information, but you may prefer to do some research
for yourself.
          1 Jan 1900 was a Monday.
          Thirty days has September,
          April, June and November.
          All the rest have thirty-one,
          Saving February alone,
          Which has twenty-eight, rain or shine.
          And on leap years, twenty-nine.
          A leap year occurs on any year evenly divisible by 4, but not on a
          century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century
(1 Jan 1901 to 31 Dec 2000)?
'''

__author__ = 'SUN'

if __name__ == '__main__':
    cnt = 0
    for i in range(1901, 2001):
        for j in range(1, 13):
            if j <= 2:
                j += 12
                i -= 1
            w = i // 100 // 4 - 2 * i // 100 + i % 100 + i % 100 // 4 + 13 * (j + 1) // 5
            w = (w % 7 + 7) % 7
            if w == 0:
                cnt += 1
    print(cnt)