/*
 * Determine if a Sudoku is valid, according to: 
 * Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where 
 * empty cells are filled with the character '.'.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[] col = new int[9];
        int[] block = new int[9];
        for (int i = 0; i < 9; ++i) {
            int row = 0;
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                int mask = 1 << (board[i][j] - '1');
                if ((row & mask) != 0 || (col[j] & mask) != 0 || 
                        (block[i / 3 * 3 + j / 3] & mask) != 0)
                    return false;
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
                if (board[i][j] == '.')
                    continue;
                int c = board[i][j] - '1';
                if (row[i][c] || col[c][j] || block[i / 3 * 3 + j / 3][c])
                    return false;
                row[i][c] = col[c][j] = block[i / 3 * 3 + j / 3][c] = true;
            }
        }
        return true;
    }

}
