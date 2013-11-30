/*
 * Given a boolean 2D matrix, find the number of islands.

Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.

Note
0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. 
We only consider up/down/left/right adjacent.
 */
public class NumberOfIslands {

    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j]) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public void dfs(boolean[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || 
                y >= grid[0].length || !grid[x][y]) {
            return;
        }
        grid[x][y] = false;
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }

}
