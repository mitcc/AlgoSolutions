import time

__author__ = 'SUN'

def sum_square_diff(start, end):
    total = 0
    for i in range(start, end):
        for j in range(i + 1, end + 1):
            total += i * j
    total *= 2
    return total

if __name__ == '__main__':
    start = time.clock()
    print(sum_square_diff(1, 100))
    print('Runtime is', time.clock() - start)