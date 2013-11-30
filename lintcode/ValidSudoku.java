/*
 * Determine whether a Sudoku is valid.

The Sudoku board could be partially filled, where 
empty cells are filled with the character ..

 Notice

A valid Sudoku board (partially filled) is not 
necessarily solvable. Only the filled cells need 
to be validated.

Clarification
What is Sudoku?

http://sudoku.com.au/TheRules.aspx
https://zh.wikipedia.org/wiki/%E6%95%B8%E7%8D%A8
https://en.wikipedia.org/wiki/Sudoku
http://baike.baidu.com/subview/961/10842669.htm
 */
public class ValidSudoku {

    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        int[] col = new int[9];
        int[] block = new int[9];
        for (int i = 0; i < 9; ++i) {
            int row = 0;
            for (int j = 0; j < 9; ++j) {
                int c = board[i][j] - '1';
                if (c < 0 || c > 8) {
                    continue;
                }
                int mask = 1 << c;
                if ((mask & row) != 0 || (mask & col[j]) != 0 || 
                        (mask & block[i / 3 * 3 + j / 3]) != 0) {
                    return false;
                }
                row |= mask;
                col[j] |= mask;
                block[i / 3 * 3 + j / 3] |= mask;
            }
        }
        return true;
    }

/*****************************************************************************/

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                int c = board[i][j] - '1';
                if (c < 0 || c > 8) {
                    continue;
                }
                if (row[i][c] || col[c][j] || block[i / 3 * 3 + j / 3][c]) {
                    return false;
                }
                row[i][c] = true;
                col[c][j] = true;
                block[i / 3 * 3 + j / 3][c] = true;
            }
        }
        return true;
    }

}
