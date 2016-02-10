import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  private boolean solveNQueens_check(int n, char[][] stack) {
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (stack[i][j] != '.') {
          count++;
        }
      }
      if (count > 1) {
        return false;
      }
    }
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (stack[j][i] != '.') {
          count++;
        }
      }
      if (count > 1) {
        return false;
      }
    }
    for (int k = 0; k <= 2 * n - 2; k++) {
      int count = 0;
      for (int i = 0; i < n; i++) {
        int j = k - i;
        if (0 <= j && j < n && stack[i][j] != '.') {
          count++;
        }
      }
      if (count > 1) {
        return false;
      }
    }
    for (int k = -(n - 1); k <= n - 1; k++) {
      int count = 0;
      for (int i = 0; i < n; i++) {
        int j = i - k;
        if (0 <= j && j < n && stack[i][j] != '.') {
          count++;
        }
      }
      if (count > 1) {
        return false;
      }
    }
    return true;
  }

  private void solveNQueens_bt(int n, int working_row, List<List<String>> ret, char[][] stack) {
    if (working_row == n) {
      List<String> report = new ArrayList<>();
      for (char[] row : stack) {
        report.add(new String(row));
      }
      ret.add(report);
    } else {
      for (int i = 0; i < n; i++) {
        stack[working_row][i] = 'Q';
        if (solveNQueens_check(n, stack)) {
          solveNQueens_bt(n, working_row + 1, ret, stack);
        }
        stack[working_row][i] = '.';
      }
    }
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ret = new ArrayList<>();
    char[][] stack = new char[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(stack[i], '.');
    }
    solveNQueens_bt(n, 0, ret, stack);
    return ret;
  }
}
-------------
public class Solution {
  private boolean check(int[] stack, int row) {
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

  private void dfs(List<List<String>> ret, int[] stack, int row) {
    if (row == stack.length) {
      List<String> l = new ArrayList<>();
      for (int i = 0; i < stack.length; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < stack[i]; j++) {
          sb.append('.');
        }
        sb.append('Q');
        for (int j = stack[i] + 1; j < stack.length; j++) {
          sb.append('.');
        }
        l.add(sb.toString());
      }
      ret.add(l);
      return;
    }
    for (int i = 0; i < stack.length; i++) {
      stack[row] = i;
      if (check(stack, row)) {
        dfs(ret, stack, row + 1);
      }
    }
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ret = new ArrayList<>();
    dfs(ret, new int[n], 0);
    return ret;
  }
}
