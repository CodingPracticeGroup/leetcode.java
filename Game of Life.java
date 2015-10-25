public class Solution {
  private int gameOfLife_count(int[][] board, int i, int j, int[][] cache, int m, int n) {
    int count = 0;

    if (j - 1 >= 0 && cache[0][j - 1] == 1)
      count++;
    if (cache[0][j] == 1)
      count++;
    if (j + 1 < n && cache[0][j + 1] == 1)
      count++;
    if (j - 1 >= 0 && cache[1][j - 1] == 1)
      count++;

    if (j + 1 < n && board[i][j + 1] == 1)
      count++;
    if (i + 1 < m && j - 1 >= 0 && board[i + 1][j - 1] == 1)
      count++;
    if (i + 1 < m && board[i + 1][j] == 1)
      count++;
    if (i + 1 < m && j + 1 < n && board[i + 1][j + 1] == 1)
      count++;

    return count;
  }

  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    int[][] cache = new int[2][n];
    Arrays.fill(cache[0], -1);
    Arrays.fill(cache[1], -1);

    for (int i = 0; i < m; i++) {
      for (int k = 0; k < n; k++) {
        cache[0][k] = cache[1][k];
        cache[1][k] = board[i][k];
      }
      for (int j = 0; j < n; j++) {
        int count = gameOfLife_count(board, i, j, cache, m, n);
        if (board[i][j] == 1) {
          if (count < 2 || count > 3)
            board[i][j] = 0;
          else
            board[i][j] = 1;
        } else {
          if (count == 3)
            board[i][j] = 1;
          else
            board[i][j] = 0;
        }
      }
    }
  }
}
