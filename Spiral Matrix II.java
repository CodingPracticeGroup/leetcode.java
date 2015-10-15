public class Solution {
  private void generateMatrix(int n, int k, int[][] board) {
    int start = 1;
    if (k > 0) {
      start = board[k][k - 1] + 1;
    }
    if (n - k - k == 1) {
      board[k][k] = start;
    } else {
      for (int i = k; i < n - k - 1; i++) {
        board[k][i] = start++;
      }
      for (int i = k; i < n - k - 1; i++) {
        board[i][n - k - 1] = start++;
      }
      for (int i = n - k - 1; i > k; i--) {
        board[n - k - 1][i] = start++;
      }
      for (int i = n - k - 1; i > k; i--) {
        board[i][k] = start++;
      }
    }
  }

  public int[][] generateMatrix(int n) {
    int[][] board = new int[n][n];
    for (int i = 0; i < n / 2 + n % 2; i++) {
      generateMatrix(n, i, board);
    }
    return board;
  }
}
