public class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }

    int i, j;
    int len = s.length();
    char[][] map = new char[numRows][len];
    for (i = 0; i < numRows; i++) {
      for (j = 0; j < len; j++) {
        map[i][j] = 0;
      }
    }

    i = 0;
    j = 0;
    boolean down = true;
    for (int k = 0; k < len; k++) {
      char c = s.charAt(k);
      map[i][j] = c;

      if (down) {
        if (i == numRows - 1) {
          down = false;
          i--;
          j++;
        } else {
          i++;
        }
      } else {
        if (i == 0) {
          down = true;
          i++;
        } else {
          i--;
          j++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (i = 0; i < numRows; i++) {
      for (j = 0; j < len; j++) {
        if (map[i][j] != 0) {
          sb.append(map[i][j]);
        }
      }
    }
    return sb.toString();
  }
}
