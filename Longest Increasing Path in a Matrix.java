public class Solution {
  private int l(int[][] matrix, int i, int j, int dp[][], int m, int n) {
    if (dp[i][j] > 0) {
      return dp[i][j];
    }

    int mark = matrix[i][j]; // push
    matrix[i][j] = 0;

    int ret = 1;
    if (i - 1 >= 0 && matrix[i - 1][j] > mark) {
      ret = Math.max(ret, 1 + l(matrix, i - 1, j, dp, m, n));
    }
    if (j - 1 >= 0 && matrix[i][j - 1] > mark) {
      ret = Math.max(ret, 1 + l(matrix, i, j - 1, dp, m, n));
    }
    if (i + 1 < m && matrix[i + 1][j] > mark) {
      ret = Math.max(ret, 1 + l(matrix, i + 1, j, dp, m, n));
    }
    if (j + 1 < n && matrix[i][j + 1] > mark) {
      ret = Math.max(ret, 1 + l(matrix, i, j + 1, dp, m, n));
    }

    matrix[i][j] = mark; // pop

    dp[i][j] = ret;
    return ret;
  }

  public int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length;
    if (m == 0) {
      return 0;
    }
    int n = matrix[0].length;
    if (n == 0) {
      return 0;
    }
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], 0);
    }
    int ret = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        ret = Math.max(ret, l(matrix, i, j, dp, m, n));
      }
    }
    return ret;
  }
}
