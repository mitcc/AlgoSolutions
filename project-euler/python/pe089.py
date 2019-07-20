"""
Roman numerals
Problem 89
The rules for writing Roman numerals allow for many ways of writing each number
(see About Roman Numerals...). However, there is always a "best" way of
writing a particular number.

For example, the following represent all of the legitimate ways of writing the
number sixteen:

IIIIIIIIIIIIIIII
VIIIIIIIIIII
VVIIIIII
XIIIIII
VVVI
XVI

The last example being considered the most efficient, as it uses the least
number of numerals.

The 11K text file, roman.txt (right click and 'Save Link/Target As...'),
contains one thousand numbers written in valid, but not necessarily minimal,
Roman numerals; that is, they are arranged in descending units and obey the
subtractive pair rule (see About Roman Numerals... for the definitive rules
for this problem).

Find the number of characters saved by writing each of these in their minimal
form.

Note: You can assume that all the Roman numerals in the file contain no more
than four consecutive identical units.
"""
__date__ = '14-4-15'
__author__ = 'SUN'

if __name__ == '__main__':
    f = open('pe089.txt')
    src = ''
    r = ''
    for line in f:
        src += line
        s = line.replace('DCCCC', 'CM')
        s = s.replace('CCCC', 'CD')
        s = s.replace('LXXXX', 'XC')
        s = s.replace('XXXX', 'XL')
        s = s.replace('VIIII', 'IX')
        s = s.replace('IIII', 'IV')
        r += s
    print(len(src) - len(r))