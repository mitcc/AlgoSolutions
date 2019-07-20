"""
Passcode derivation
Problem 79
A common security method used for online banking is to ask the user for three
random characters from a passcode. For example, if the passcode was 531278,
they may ask for the 2nd, 3rd, and 5th characters; the expected reply would
be: 317.

The text file, keylog.txt, contains fifty successful login attempts.

Given that the three characters are always asked for in inter, analyse the file
so as to determine the shortest possible secret passcode of unknown length.
"""
__date__ = '14-4-9'
__author__ = 'SUN'

if __name__ == '__main__':
    after = [set() for x in range(10)]
    before = [set() for x in range(10)]

    f = open('pe079.txt')
    for line in f:
        num = line[0:3]
        for i in range(0, 2):
            for j in range(i + 1, 3):
                after[int(num[i])].add(int(num[j]))
                before[int(num[j])].add(int(num[i]))
    for i in range(10):
        print('after', i, ':', after[i])
    print('=================================')
    for i in range(10):
        print('before', i, ':', before[i])