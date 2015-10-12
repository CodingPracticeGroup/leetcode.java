public class Solution {
  private boolean isValidSudoku_row(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set<Integer> s = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          if (s.contains(board[i][j] - '0')) {
            s.remove(board[i][j] - '0');
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean isValidSudoku_col(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set<Integer> s = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
      for (int j = 0; j < 9; j++) {
        if (board[j][i] != '.') {
          if (s.contains(board[j][i] - '0')) {
            s.remove(board[j][i] - '0');
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean isValidSudoku_block(char[][] board) {
    for (int i = 1; i < 9; i += 3) {
      for (int j = 1; j < 9; j += 3) {
        Set<Integer> s = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
        for (int k = i - 1; k <= i + 1; k++) {
          for (int m = j - 1; m <= j + 1; m++) {
            if (board[k][m] != '.') {
              if (s.contains(board[k][m] - '0')) {
                s.remove(board[k][m] - '0');
              } else {
                return false;
              }
            }
          }
        }
      }
    }
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    boolean ret = true;
    ret = ret && isValidSudoku_row(board);
    ret = ret && isValidSudoku_col(board);
    ret = ret && isValidSudoku_block(board);
    return ret;
  }
}
