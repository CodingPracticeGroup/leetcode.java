public class Solution {
  private void numIslands_visit(char[][] grid, int m, int n, int i, int j) {
    if (grid[i][j] == '1') {
      grid[i][j] = '2';
      if (i - 1 >= 0)
        numIslands_visit(grid, m, n, i - 1, j);
      if (j - 1 >= 0)
        numIslands_visit(grid, m, n, i, j - 1);
      if (i + 1 < m)
        numIslands_visit(grid, m, n, i + 1, j);
      if (j + 1 < n)
        numIslands_visit(grid, m, n, i, j + 1);
    }
  }

  public int numIslands(char[][] grid) {
    int count = 0;
    int m = grid.length;
    if (m == 0)
      return count;
    int n = grid[0].length;
    if (n == 0)
      return count;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          count++;
          numIslands_visit(grid, m, n, i, j);
        }
      }
    }
    return count;
  }
}
