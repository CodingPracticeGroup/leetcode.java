public class Solution {
  private boolean totalNQueens_check(int n, int[] colPos) {
    for (int i = 0; i < n; i++) { // point {i, colPos[i]}
      for (int j = i + 1; j < n; j++) { // point {j, colPos[j]}
        if (colPos[i] >= 0 && colPos[j] >= 0) {
          if (colPos[i] == colPos[j]) { // same col
            return false;
          }
          if (i - colPos[i] == j - colPos[j]) { // same \
            return false;
          }
          if (i + colPos[i] == j + colPos[j]) { // same /
            return false;
          }
        }
      }
    }
    return true;
  }

  private void totalNQueens_bt(int n, int working_row, int[] ret, int[] colPos) {
    if (working_row == n) {
      ret[0]++;
    } else {
      for (int i = 0; i < n; i++) {
        colPos[working_row] = i;
        if (totalNQueens_check(n, colPos)) {
          totalNQueens_bt(n, working_row + 1, ret, colPos);
        }
        colPos[working_row] = -1;
      }
    }
  }

  public int totalNQueens(int n) {
    int[] ret = new int[1];
    ret[0] = 0;
    int[] colPos = new int[n];
    Arrays.fill(colPos, -1);
    totalNQueens_bt(n, 0, ret, colPos);
    return ret[0];
  }
}
-----------------
public class Solution {
  private boolean check(int stack[], int row) {
    for (int i = 0; i < row; i++) {
      if (stack[i] == stack[row]) {
        return false;
      }
      if (stack[i] + i == stack[row] + row) {
        return false;
      }
      if (stack[i] - i == stack[row] - row) {
        return false;
      }
    }
    return true;
  }

  private int dfs(int stack[], int row) {
    if (row == stack.length) {
      return 1;
    }
    int ret = 0;
    for (int i = 0; i < stack.length; i++) {
      stack[row] = i;
      if (check(stack, row)) {
        ret += dfs(stack, row + 1);
      }
    }
    return ret;
  }

  public int totalNQueens(int n) {
    return dfs(new int[n], 0);
  }
}
