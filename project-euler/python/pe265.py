'''
2N binary digits can be placed in a circle so that all the N-digit clockwise
subsequences are distinct.

For N=3, two such circular arrangements are possible, ignoring rotations:


For the first arrangement, the 3-digit subsequences, in clockwise order, are:
000, 001, 010, 101, 011, 111, 110 and 100.

Each circular arrangement can be encoded as a number by concatenating the binary
digits starting with the subsequence of all zeros as the most significant bits
and proceeding clockwise. The two arrangements for N=3 are thus represented as
23 and 29:

(00010111 )2 = 23
(00011101) 2 = 29
Calling S(N) the sum of the unique numeric representations, we can see that
S(3) = 23 + 29 = 52.

Find S(5).
'''
__date__ = '14-3-2'
__author__ = 'SUN'

def dfs(circle, sub_list, n):
    if len(sub_list) == 1 << n:
        bin_str = ''
        for b in sub_list:
            bin_str += b[0]
        circle.append(bin_str)
        return None
    cur = sub_list[-1][1:n] + '0'
    if not cur in sub_list:
        dfs(circle, sub_list + [cur], n)
    cur = sub_list[-1][1:n] + '1'
    if not cur in sub_list:
        dfs(circle, sub_list + [cur], n)

if __name__ == '__main__':
    array = []
    dfs(array, ['00000'], 5)
    res = sum(int(s, 2) for s in array)
    print(res)