'''
Triangle containment
Problem 102
Three distinct points are plotted at random on a Cartesian plane, for which
-1000 ≤ x, y ≤ 1000, such that a triangle is formed.

Consider the following two triangles:

A(-340,495), B(-153,-910), C(835,-947)

X(-175,41), Y(-421,-714), Z(574,-645)

It can be verified that triangle ABC contains the origin, whereas triangle XYZ
does not.

Using triangles.txt (right click and 'Save Link/Target As...'), a 27K text file
containing the co-ordinates of one thousand "random" triangles, find the number
of triangles for which the interior contains the origin.

NOTE: The first two examples in the file represent the triangles in the example
given above.
'''
__date__ = '14-3-9'
__author__ = 'SUN'

if __name__ == '__main__':
    cnt = 0
    f = open('pe102.txt')
    for line in f:
        triangles = [int(x) for x in line.split(',')]
        nu = triangles[4] * triangles[1] - triangles[0] * triangles[5]
        nv = triangles[0] * triangles[3] - triangles[2] * triangles[1]
        denominator = (triangles[2] - triangles[0]) * (triangles[5] - triangles[1]) - (triangles[4] - triangles[0]) * (triangles[3] - triangles[1])
        if nu / denominator > 0 and nv / denominator > 0 and (nu + nv) / denominator < 1:
            cnt += 1
    print(cnt)