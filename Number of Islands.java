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
-------------
public class Solution {
  private void mark2(char[][] grid, int i, int j) { // dfs不用开存储，但是改原值。最后其实可以再改回来
    grid[i][j] = '2';
    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
      mark2(grid, i - 1, j);
    }
    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
      mark2(grid, i, j - 1);
    }
    if (i + 1 < grid.length && grid[i + 1][j] == '1') {
      mark2(grid, i + 1, j);
    }
    if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
      mark2(grid, i, j + 1);
    }
  }

  public int numIslands(char[][] grid) {
    int ret = 0;
    int m = grid.length;
    if (m == 0) {
      return ret;
    }
    int n = grid[0].length;
    if (n == 0) {
      return ret;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          ret++;
          mark2(grid, i, j);
        }
      }
    }
    return ret;
  }
}
-----------------
public class Solution {
  int dirs[][] = new int[][] {{-1, 0}, {+1, 0}, {0, -1}, {0, 1}};

  public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0)
      return 0;

    int[] islands = new int[grid.length * grid[0].length]; // 初始化孤岛
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        int idx = i * grid[0].length + j;
        if (grid[i][j] == '1') {
          islands[idx] = idx;
        } else {
          islands[idx] = -1;
        }
      }
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          int root1 = find(islands, i * grid[0].length + j);
          for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') { // 找到
              int root2 = find(islands, x * grid[0].length + y);
              islands[root2] = root1; // 合并
            }
          }
        }
      }
    }

    int ret = 0;
    for (int i = 0; i < islands.length; i++) { // 统计
      if (islands[i] == i) {
        ret++;
      }
    }
    return ret;
  }

  int find(int[] islands, int idx) {
    while (islands[idx] != idx) { // 找根
      idx = islands[idx];
    }
    return idx;
  }
}
