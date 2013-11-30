"""
Path sum: two ways
Problem 81
In the 5 by 5 matrix below, the minimal path sum from the top left to the
bottom right, by only moving to the right and down, is indicated in bold red
and is equal to 2427.


131	673	234	103	18
201	96	342	965	150
630	803	746	422	111
537	699	497	121	956
805	732	524	37	331

Find the minimal path sum, in matrix.txt (right click and 'Save Link/Target
As...'), a 31K text file containing a 80 by 80 matrix, from the top left to
the bottom right by only moving right and down.
"""
__date__ = '14-4-13'
__author__ = 'SUN'

if __name__ == '__main__':
    matrix = []
    f = open('pe081.txt')
    for line in f:
        matrix.append([int(x) for x in line.split(',')])
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if i == 0 and j == 0:
                continue
            elif i == 0:
                matrix[i][j] += matrix[i][j - 1]
            elif j == 0:
                matrix[i][j] += matrix[i - 1][j]
            else:
                matrix[i][j] += min(matrix[i][j - 1], matrix[i - 1][j])
    print(matrix[len(matrix) - 1][len(matrix[0]) - 1])