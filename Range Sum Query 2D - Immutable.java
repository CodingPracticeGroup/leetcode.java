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
