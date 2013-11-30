/*
 * You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Example
Given a matrix

[
    [1,2],
    [3,4]
]
rotate it by 90 degrees (clockwise), return

[
    [3,1],
    [4,2]
]
Challenge
Do it in-place.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        for (int i = 0; i < (xLen + 1) / 2; ++i) {
            for (int j = 0; j < yLen / 2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[xLen - 1 - j][i];
                matrix[xLen - 1 - j][i] = matrix[xLen - 1 - i][yLen - 1 - j];
                matrix[xLen - 1 - i][yLen - 1 - j] = matrix[j][yLen - 1 - i];
                matrix[j][yLen - 1 - i] = tmp;
            }
        }
    }

}
