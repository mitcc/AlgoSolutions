/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent 
cell, where "adjacent" cells are those horizontally or vertically 
neighboring. The same letter cell may not be used more than once.

Example
Given board =

[
  "ABCE",
  "SFCS",
  "ADEE"
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class WordSearch {

    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
                board[i][j] != word.charAt(0) || board[i][j] == '#') {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }
        board[i][j] = '#';
        boolean result = dfs(board, word.substring(1), i - 1, j) || 
            dfs(board, word.substring(1), i + 1, j) || 
            dfs(board, word.substring(1), i, j - 1) || 
            dfs(board, word.substring(1), i, j + 1);
        board[i][j] = word.charAt(0);
        return result;
    }

}
