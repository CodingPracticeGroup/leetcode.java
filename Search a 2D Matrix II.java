public class Solution {
  private boolean searchMatrix(int[][] matrix, int target, int left, int right, int top, int bottom) {
    if (left > right || top > bottom)
      return false;
    int j = left + (right - left) / 2;
    int i = top + (bottom - top) / 2;
    if (matrix[i][j] < target) {
      return searchMatrix(matrix, target, left, j, i + 1, bottom)
          || searchMatrix(matrix, target, j + 1, right, i + 1, bottom)
          || searchMatrix(matrix, target, j + 1, right, top, i);
    } else if (matrix[i][j] > target) {
      return searchMatrix(matrix, target, left, j - 1, top, i - 1)
          || searchMatrix(matrix, target, left, j - 1, i, bottom)
          || searchMatrix(matrix, target, j, right, top, i - 1);
    } else {
      return true;
    }
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0)
      return false;
    int n = matrix[0].length;
    if (n == 0)
      return false;
    return searchMatrix(matrix, target, 0, n - 1, 0, m - 1);
  }
}
