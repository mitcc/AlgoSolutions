"""
Coded triangle numbers
Problem 42
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so
the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its
alphabetical position and adding these values we form a word value. For
example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value
is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file
containing nearly two-thousand common English words, how many are triangle
words?
"""
__date__ = '14-3-23'
__author__ = 'SUN'

if __name__ == '__main__':
    f = open('pe042.txt')
    words = f.read().split(',')
    words = [word.strip('\"') for word in words]
    f.close()

    maxLen = max(len(word) for word in words)
    maxValue = maxLen * (ord('Z') - ord('A') + 1)
    triangle = []
    i = 1
    while i * (i + 1) // 2 <= maxValue:
        triangle.append(i * (i + 1) // 2)
        i += 1

    cnt = 0
    for word in words:
        value = sum(ord(c) - ord('A') + 1 for c in word)
        if value in triangle:
            cnt += 1
    print(cnt)