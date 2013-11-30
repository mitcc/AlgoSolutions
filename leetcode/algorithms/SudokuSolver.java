/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 * Empty cells are indicated by the character '.'.

 * You may assume that there will be only one unique solution.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int row, int col) {
        if (col >= board[0].length)
            return dfs(board, row + 1, 0);
        if (row >= board.length)
            return true;
        if (board[row][col] == '.') {
            for (char c = '1'; c <= '9'; ++c) {
                board[row][col] = c;
                if (isValid(board, row, col) && dfs(board, row, col + 1)) 
                    return true;
                board[row][col] = '.';
            }
        } else {
            return dfs(board, row, col + 1);
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < 9; ++i) {
            if (i != row && board[i][col] == board[row][col] 
                    || i != col && board[row][i] == board[row][col])
                return false;
            int m = i / 3 + row / 3 * 3;
            int n = i % 3 + col / 3 * 3;
            if (m != row && n != col && board[m][n] == board[row][col])
                return false;
        }
        return true;
    }

/*****************************************************************************/

    public void solveSudoku(char[][] board) {
        List<Integer> list = getBlankPositions(board);
        dfs(board, list, 0);
    }

    public List<Integer> getBlankPositions(char[][] board) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.')
                    result.add(i * 9 + j);
            }
        }
        return result;
    }

    public boolean dfs(char[][] board, List<Integer> list, int index) {
        if (index == list.size())
            return true;
        int row = list.get(index) / 9;
        int col = list.get(index) % 9;
        for (char c = '1'; c <= '9'; ++c) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (dfs(board, list, index + 1))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char value) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] == value || board[row][i] == value || 
                    board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == value)
                return false;
        }
        return true;
    }

}
