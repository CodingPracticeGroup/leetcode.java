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
-------------
public class Solution {
  int dirs[][] = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

  private boolean dfs(char[][] b, int i, int j, String word, int startPos) {
    if (startPos == word.length() - 1) {
      if (b[i][j] == word.charAt(startPos)) {
        return true;
      } else {
        return false;
      }
    }
    if (b[i][j] != word.charAt(startPos)) {
      return false;
    }
    b[i][j] ^= -1;
    for (int[] dir : dirs) {
      if (i + dir[0] >= 0 && i + dir[0] < b.length && j + dir[1] >= 0 && j + dir[1] < b[0].length) {
        if (dfs(b, i + dir[0], j + dir[1], word, startPos + 1)) {
          return true;
        }
      }
    }
    b[i][j] ^= -1;
    return false;
  }

  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dfs(board, i, j, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }
}
