public class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    char[][] board = new char[numRows][s.length()];
    for (char[] c : board) {
      Arrays.fill(c, '$');
    }
    int r = 0;
    int c = 0;
    boolean down = true;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      board[r][c] = ch;
      if (down) { // for next
        r++;
      } else {
        r--;
        c++;
      }
      if (r == 0) { // for next
        down = true;
      } else if (r == numRows - 1) {
        down = false;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < s.length(); j++) {
        if (board[i][j] != '$') {
          sb.append(board[i][j]);
        }
      }
    }
    return sb.toString();
  }
}
