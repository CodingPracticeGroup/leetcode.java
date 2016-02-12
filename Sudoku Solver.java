public class Solution {
  private boolean solveSudoku_check(char[][] board, int i, int j) {
    Set<Character> s =
        Stream.of('1', '2', '3', '4', '5', '6', '7', '8', '9').collect(Collectors.toSet());
    Set<Character> row = new HashSet<>(s);
    for (int k = 0; k < 9; k++) {
      if (board[i][k] != '.') {
        if (row.contains(board[i][k])) {
          row.remove(board[i][k]);
        } else {
          return false;
        }
      }
    }
    Set<Character> col = new HashSet<>(s);
    for (int k = 0; k < 9; k++) {
      if (board[k][j] != '.') {
        if (col.contains(board[k][j])) {
          col.remove(board[k][j]);
        } else {
          return false;
        }
      }
    }
    Set<Character> block = new HashSet<>(s);
    int i_ = (i / 3) * 3 + 1;
    int j_ = (j / 3) * 3 + 1;
    for (int k = i_ - 1; k <= i_ + 1; k++) {
      for (int m = j_ - 1; m <= j_ + 1; m++) {
        if (board[k][m] != '.') {
          if (block.contains(board[k][m])) {
            block.remove(board[k][m]);
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean solveSudoku_(char[][] board, int i, int j) {
    outerloop: for (; i < 9; i++) {
      for (j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          break outerloop;
        }
      }
    }
    if (i == 9 && j == 9) {// found
      return true;// report
    }

    for (char k = '1'; k <= '9'; k++) {// candidates
      board[i][j] = k;// forward
      if (solveSudoku_check(board, i, j)) {// prune
        if (solveSudoku_(board, i, j)) {// explore
          return true;
        }
      }
    }
    board[i][j] = '.';// backward
    return false;
  }

  public void solveSudoku(char[][] board) {
    solveSudoku_(board, 0, 0);
  }
}
--------------------
public class Solution {
  private boolean check(char[][] board, int i, int j, char c) {
    for (int k = 0; k < 9; k++) {
      if (board[i][k] == c) {
        return false;
      }
    }

    for (int k = 0; k < 9; k++) {
      if (board[k][j] == c) {
        return false;
      }
    }

    i = (i / 3) * 3;
    j = (j / 3) * 3;
    for (int p = 0; p < 3; p++) {
      for (int q = 0; q < 3; q++) {
        int x = i + p;
        int y = j + q;
        if (board[x][y] == c) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean dfs(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          for (char k = '1'; k <= '9'; k++) {
            if (check(board, i, j, k)) {
              board[i][j] = k;
              if (dfs(board)) {
                return true; // termination
              }
              board[i][j] = '.';
            }
          }
          return false; // prune
        }
      }
    }
    return true; // termination
  }

  public void solveSudoku(char[][] board) {
    dfs(board);
  }
}
