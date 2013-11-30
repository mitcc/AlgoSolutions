'''
Names scores
Problem 22
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
containing over five-thousand first names, begin by sorting it into alphabetical
order. Then working out the alphabetical value for each name, multiply this
value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is
worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would
obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
'''

__date__ = '14-3-11'
__author__ = 'SUN'

if __name__ == '__main__':
    with open('pe022.txt') as f:
        data = f.readline()
    names = sorted([name.strip('"') for name in data.split(",")])
    res = 0
    for i in range(len(names)):
        res += (i + 1) * sum(ord(names[i][j]) - ord('A') + 1
                             for j in range(len(names[i])))
    print(res)