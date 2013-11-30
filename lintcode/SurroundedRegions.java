/*
 * Given a 2D board containing 'X' and 'O', capture all regions 
 * surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that 
surrounded region.

Example
X X X X
X O O X
X X O X
X O X X
After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X
 */
public class SurroundedRegions {

    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    // DFS
    public void surroundedRegions(char[][] board) {
        if (board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; ++j) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || 
                j >= board[i].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'S';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

/*******************************************************************/
    // BFS
    public void surroundedRegions(char[][] board) {
        if (board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            bfs(board, i, 0);
            bfs(board, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; ++j) {
            bfs(board, 0, j);
            bfs(board, board.length - 1, j);
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board, int i, int j) {
        fill(board, i, j);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / board.length;
            int y = index % board[0].length;
            fill(board, x - 1, y);
            fill(board, x + 1, y);
            fill(board, x, y - 1);
            fill(board, x, y + 1);
        }
    }

    Queue<Integer> queue = new LinkedList<Integer>();

    public void fill(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || 
                j >= board[0].length || board[i][j] != 'O') {
            return;
        }    
        queue.offer(i * board.length + j);
        board[i][j] = 'S';
    }

}
