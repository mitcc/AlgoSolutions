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
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, word))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String s) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || s.charAt(0) != board[i][j])
            return false;
        if(s.length() == 1)
            return true;
        board[i][j] = '#';
        boolean flag = dfs(board, i - 1, j, s.substring(1, s.length())) || dfs(board, i + 1, j, s.substring(1, s.length()))
            || dfs(board, i, j - 1, s.substring(1, s.length())) || dfs(board, i, j + 1, s.substring(1, s.length()));
        board[i][j] = s.charAt(0);
        return flag;
    }
}
