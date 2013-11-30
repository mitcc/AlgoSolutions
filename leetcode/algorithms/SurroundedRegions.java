/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 * A region is captured by flipping all 'O's into 'X's in that surrounded region .

 * For example,

 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:

 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class SurroundedRegions {
/*  public void solve(char[][] board) {
        if(board.length == 0)
            return ;
        for(int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'S')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
            return ;
        board[i][j] = 'S';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
    }
*/

    int m, n;
    char[][] board;
    Queue<Integer> queue = new LinkedList<Integer>();

    public void fill(int x, int y) {
        if(x < 0 || x > m - 1 || y < 0 || y > n - 1 || board[x][y] != 'O')
            return;
        queue.offer(x * n + y);
        board[x][y] = 'S';
    }

    public void bfs(int x, int y) {
        fill(x, y);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / n;
            int j = cur % n;
            fill(i + 1, j);
            fill(i - 1, j);
            fill(i, j + 1);
            fill(i, j - 1);
        }
    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;
        this.board = board;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            bfs(i, 0);
            bfs(i, n - 1);
        }
        for(int j = 1; j < n - 1; j++) {
            bfs(0, j);
            bfs(m - 1, j);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'S')
                    board[i][j] = 'O';
            }
        }
    }

}
