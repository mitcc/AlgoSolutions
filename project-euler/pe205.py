'''
Dice Game
Problem 205
Peter has nine four-sided (pyramidal) dice, each with faces numbered 1, 2, 3, 4.
Colin has six six-sided (cubic) dice, each with faces numbered 1, 2, 3, 4, 5, 6.

Peter and Colin roll their dice and compare totals: the highest total wins. The
result is a draw if the totals are equal.

What is the probability that Pyramidal Pete beats Cubic Colin? Give your answer
rounded to seven decimal places in the form 0.abcdefg
'''

__date__ = '14-3-3'
__author__ = 'SUN'

if __name__ == '__main__':
    p = [0] * 37
    for a in range(1, 5):
        for b in range(1, 5):
            for c in range(1, 5):
                for d in range(1, 5):
                    for e in range(1, 5):
                        for f in range(1, 5):
                            for g in range(1, 5):
                                for h in range(1, 5):
                                    for i in range(1, 5):
                                        p[a + b + c + d + e + f + g + h + i] += 1

    c = [0] * 37
    for i in range(1, 7):
        for j in range(1, 7):
            for k in range(1, 7):
                for l in range(1, 7):
                    for m in range(1, 7):
                        for n in range(1, 7):
                            c[i + j + k + l + m + n] += 1

    res = 0
    for i in range(9, 37):
        res += p[i] * sum(c[0:i])
    print(round(res / (4 ** 9 * 6 ** 6), 7))