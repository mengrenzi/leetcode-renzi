class Solution {
  public int numIslands(char[][] grid) {
    int numLands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          grid[i][j] = '0';
          dfs(grid, i, j);
          numLands++;
        }
      }
    }
    return numLands;
  }

  int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

  void dfs(char[][] grid, int i, int j) {
    for (int[] dir : dirs) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
        grid[x][y] = '0';
        dfs(grid, x, y);
      }
    }
  }

}