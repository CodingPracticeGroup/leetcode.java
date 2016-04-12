public class Solution {
  private boolean row(char[][] board) {
    Set<Character> seen = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      seen.clear();
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          if (seen.contains(board[i][j])) {
            return false;
          } else {
            seen.add(board[i][j]);
          }
        }
      }
    }
    return true;
  }

  private boolean column(char[][] board) {
    Set<Character> seen = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      seen.clear();
      for (int j = 0; j < 9; j++) {
        if (board[j][i] != '.') {
          if (seen.contains(board[j][i])) {
            return false;
          } else {
            seen.add(board[j][i]);
          }
        }
      }
    }
    return true;
  }

  private boolean block(char[][] board) {
    Set<Character> seen = new HashSet<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        seen.clear();
        for (int m = 0; m < 3; m++) {
          for (int n = 0; n < 3; n++) {
            if (board[i * 3 + m][j * 3 + n] != '.') {
              if (seen.contains(board[i * 3 + m][j * 3 + n])) {
                return false;
              } else {
                seen.add(board[i * 3 + m][j * 3 + n]);
              }
            }
          }
        }
      }
    }
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    boolean r = row(board);
    boolean c = column(board);
    boolean b = block(board);
    return r && c && b;
  }
}
---------------
public class Solution {
  boolean blocks(char[][] board) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        Set<Character> s = new HashSet<>();
        for (int m = 0; m < 3; m++) {
          for (int n = 0; n < 3; n++) {
            int x = i * 3 + m;
            int y = j * 3 + n;
            if (board[x][y] != '.' && !s.add(board[x][y]))
              return false;
          }
        }
      }
    }
    return true;
  }

  boolean cols(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set<Character> s = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        if (board[j][i] != '.' && !s.add(board[j][i]))
          return false;
      }
    }
    return true;
  }

  boolean rows(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set<Character> s = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.' && !s.add(board[i][j]))
          return false;
      }
    }
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    return rows(board) && cols(board) && blocks(board);
  }
}
