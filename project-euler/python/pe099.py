"""
Largest exponential
Problem 99
Comparing two numbers written in index form like 2^11 and 3^7 is not difficult,
as any calculator would confirm that 2^11 = 2048 < 3^7 = 2187.

However, confirming that 632382^518061 > 519432^525806 would be much more
difficult, as both numbers contain over three million digits.

Using base_exp.txt (right click and 'Save Link/Target As...'), a 22K text file
containing one thousand lines with a base/exponent pair on each line, determine
which line number has the greatest numerical value.

NOTE: The first two lines in the file represent the numbers in the example
given above.
"""
import math

__date__ = '14-4-18'
__author__ = 'SUN'

if __name__ == '__main__':
	max_value = 525806 * math.log(519432)
	count = 0
	answer = 1
	f = open('pe099.txt')
	for line in f:
		count += 1
		number = [int(x) for x in line.split(',')]
		if max_value < number[1] * math.log(number[0]):
			answer = count
			max_value = number[1] * math.log(number[0])
	print(answer)