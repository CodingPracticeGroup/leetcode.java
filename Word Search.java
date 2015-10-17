public class Solution {
  private boolean exist_dfs(char[][] board, String word, int i, int j, int m, int n, int start) {
    if (start == word.length() - 1 && board[i][j] == word.charAt(start)) {
      return true;
    } else {
      if (board[i][j] == word.charAt(start)) {
        char tmp = board[i][j];
        board[i][j] = 0;
        if (i - 1 >= 0 && exist_dfs(board, word, i - 1, j, m, n, start + 1)) {
          board[i][j] = tmp;
          return true;
        }
        if (i + 1 < m && exist_dfs(board, word, i + 1, j, m, n, start + 1)) {
          board[i][j] = tmp;
          return true;
        }
        if (j + 1 < n && exist_dfs(board, word, i, j + 1, m, n, start + 1)) {
          board[i][j] = tmp;
          return true;
        }
        if (j - 1 >= 0 && exist_dfs(board, word, i, j - 1, m, n, start + 1)) {
          board[i][j] = tmp;
          return true;
        }
        board[i][j] = tmp;
      }
      return false;
    }
  }

  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (exist_dfs(board, word, i, j, m, n, 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
