public class NumMatrix {
  int dp[][] = null;
  int row = -1;
  int col = -1;

  public NumMatrix(int[][] matrix) {
    row = matrix.length;
    if (row == 0)
      return;
    col = matrix[0].length;
    dp = new int[row][col];
    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 1; j >= 0; j--) {
        dp[i][j] =
            (i + 1 < row ? dp[i + 1][j] : 0) + (j + 1 < col ? dp[i][j + 1] : 0)
                - (i + 1 < row && j + 1 < col ? dp[i + 1][j + 1] : 0) + matrix[i][j];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (dp == null)
      return 0;
    return dp[row1][col1] - (col2 + 1 < col ? dp[row1][col2 + 1] : 0)
        - (row2 + 1 < row ? dp[row2 + 1][col1] : 0)
        + (row2 + 1 < row && col2 + 1 < col ? dp[row2 + 1][col2 + 1] : 0);
  }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
--------------
public class NumMatrix {

  int[][] sum = null;

  public NumMatrix(int[][] matrix) {
    int m = matrix.length;
    if (m == 0)
      return;
    int n = matrix[0].length;
    if (n == 0)
      return;
    sum = new int[m][n];
    sum[0][0] = matrix[0][0];
    for (int i = 1; i < m; i++)
      sum[i][0] = sum[i - 1][0] + matrix[i][0];
    for (int j = 1; j < n; j++)
      sum[0][j] = sum[0][j - 1] + matrix[0][j];
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
      }
    }
  }

  private int sum(int row, int col) {
    if (row >= 0 && col >= 0 && sum != null)
      return sum[row][col];
    return 0;
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sum(row2, col2) - sum(row1 - 1, col2) - sum(row2, col1 - 1) + sum(row1 - 1, col1 - 1);
  }
}
------------------
public class NumMatrix {
  int[][] sum = null;

  public NumMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return;
    sum = new int[matrix.length][matrix[0].length];
    sum[0][0] = matrix[0][0];
    for (int i = 1; i < matrix.length; i++) {
      sum[i][0] = sum[i - 1][0] + matrix[i][0];
    }
    for (int j = 1; j < matrix[0].length; j++) {
      sum[0][j] = sum[0][j - 1] + matrix[0][j];
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (sum == null)
      return 0;
    int left = 0;
    if (col1 - 1 >= 0)
      left = sum[row2][col1 - 1];
    int top = 0;
    if (row1 - 1 >= 0)
      top = sum[row1 - 1][col2];
    int corner = 0;
    if (row1 - 1 >= 0 && col1 - 1 >= 0)
      corner = sum[row1 - 1][col1 - 1];
    return sum[row2][col2] - left - top + corner;
  }
}
