public class Solution {
  private void gameOfLife_calc(int[][] board, int i, int j, int[][] mem, int m, int n) {
    int live = 0;
    if (j - 1 >= 0 && mem[1][j - 1] == 1)
      live++;
    if (mem[1][j] == 1)
      live++;
    if (j + 1 < n && mem[1][j + 1] == 1)
      live++;
    if (j - 1 >= 0 && mem[0][j - 1] == 1)
      live++;

    if (j + 1 < n && board[i][j + 1] == 1)
      live++;
    if (i + 1 < m && j - 1 >= 0 && board[i + 1][j - 1] == 1)
      live++;
    if (i + 1 < m && board[i + 1][j] == 1)
      live++;
    if (i + 1 < m && j + 1 < n && board[i + 1][j + 1] == 1)
      live++;

    if (board[i][j] == 1) {
      if (live < 2)
        board[i][j] = 0;
      else if (live == 2 || live == 3)
        board[i][j] = 1;
      else if (live > 3)
        board[i][j] = 0;
    } else {
      if (live == 3)
        board[i][j] = 1;
    }
  }

  public void gameOfLife_(int[][] board) {
    int m = board.length;
    if (m == 0)
      return;
    int n = board[0].length;
    if (n == 0)
      return;

    int[][] mem = new int[2][n];
    Arrays.fill(mem[0], -1);
    Arrays.fill(mem[1], -1);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        mem[0][j] = board[i][j];
        gameOfLife_calc(board, i, j, mem, m, n);
      }
      for (int j = 0; j < n; j++) {
        mem[1][j] = mem[0][j];
      }
      Arrays.fill(mem[0], -1);
    }
  }

  public void gameOfLife(int[][] board) {
    int n = board[0].length;
    int cache[][] = new int[2][n];
    Arrays.fill(cache[0], 0);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < n; j++) {
        cache[1][j] = board[i][j];
        int alive = 0;
        alive += j - 1 >= 0 ? cache[0][j - 1] : 0;
        alive += cache[0][j];
        alive += j + 1 < n ? cache[0][j + 1] : 0;

        alive += j - 1 >= 0 ? cache[1][j - 1] : 0;
        alive += j + 1 < n ? board[i][j + 1] : 0;

        alive += i + 1 < board.length ? (j - 1 >= 0 ? board[i + 1][j - 1] : 0) : 0;
        alive += i + 1 < board.length ? (board[i + 1][j]) : 0;
        alive += i + 1 < board.length ? (j + 1 < n ? board[i + 1][j + 1] : 0) : 0;
        if (board[i][j] == 1) {
          if (alive < 2) {
            board[i][j] = 0;
          } else if (alive == 2 || alive == 3) {
            board[i][j] = 1;
          } else if (alive > 3) {
            board[i][j] = 0;
          }
        } else {
          if (alive == 3) {
            board[i][j] = 1;
          }
        }
      }
      for (int k = 0; k < n; k++) {
        cache[0][k] = cache[1][k];
      }
    }
  }
}
