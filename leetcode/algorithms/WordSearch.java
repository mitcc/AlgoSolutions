/*
 * Given a 2D board and a word, find if the word exists in the grid.

 * The word can be constructed from letters of sequentially adjacent
 *  cell, where "adjacent" cells are those horizontally or vertically 
 *  neighboring. The same letter cell may not be used more than once.

 * For example,
 * Given board =

 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    } 

    public boolean dfs(char[][] board, int i, int j, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
            board[i][j] != word.charAt(0))
            return false;
        if (word.length() == 1)
            return true;
        String s = word.substring(1);
        board[i][j] = '#';
        boolean result = dfs(board, i - 1, j, s) || dfs(board, i + 1, j, s) || 
                    dfs(board, i, j - 1, s) || dfs(board, i, j + 1, s);
        board[i][j] = word.charAt(0);
        return result;
    }

}
