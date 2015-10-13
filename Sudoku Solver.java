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