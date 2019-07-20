'''
Coin sums
Problem 31

In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
'''
__author__ = 'SUN'

if __name__ == '__main__':
    N = 200
    coins = [1, 2, 5, 10, 20, 50, 100, 200]
    ways = [0] * (N + 1)
    ways[0] = 1
    for i in range(len(coins)):
        for j in range(coins[i], N + 1):
            ways[j] += ways[j - coins[i]]
    print(ways[N])