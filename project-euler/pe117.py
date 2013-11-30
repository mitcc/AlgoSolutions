'''
Red, green, and blue tiles
Problem 117
Using a combination of black square tiles and oblong tiles chosen from: red
tiles measuring two units, green tiles measuring three units, and blue tiles
measuring four units, it is possible to tile a row measuring five units in
length in exactly fifteen different ways.

http://projecteuler.net/problem=117

How many ways can a row measuring fifty units in length be tiled?
'''

__date__ = '14-2-17'
__author__ = 'SUN'

def f(n):
    ways = [0] * (n + 1)
    ways[0] = 1
    for i in range(1, n + 1):
        ways[i] += ways[i - 1]
        if i >= 2:
            ways[i] += ways[i - 2]
        if i >= 3:
            ways[i] += ways[i - 3]
        if i >= 4:
            ways[i] += ways[i - 4]
    return ways[n]

if __name__ == '__main__':
    print(f(50))