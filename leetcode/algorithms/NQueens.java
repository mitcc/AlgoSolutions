/*
 * The n-queens puzzle is the problem of placing n queens on 
 * an n¡Án chessboard such that no two queens attack each 
 * other.

 * Given an integer n, return all distinct solutions to the 
 * n-queens puzzle.

 * Each solution contains a distinct board configuration of 
 * the n-queens' placement, where 'Q' and '.' both indicate a 
 * queen and an empty space respectively.

 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:

 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],

 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] board = new int[n];
        dfs(result, board, 0);
        return result;
    }

    public void dfs(List<List<String>> result, int[] board, int row) {
        if (row == board.length) {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < board.length; ++i) {
                String line = "";
                for (int j = 0; j < board.length; ++j) {
                    line += board[i] != j ? "." : "Q";
                }
                list.add(line);
            }
            result.add(list);
            return;
        }
        for (int col = 0; col < board.length; ++col) {
            if (canPlace(board, row, col)) {
                board[row] = col;
                dfs(result, board, row + 1);
                board[row] = 0;
            }
        }
    }

    public boolean canPlace(int[] board, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (board[i] == col || Math.abs(row - i) == 
                    Math.abs(board[i] - col))
                return false;
        }
        return true;
    }

}
