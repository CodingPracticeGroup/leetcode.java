public class Solution {
  private void rotate_updown(int[][] matrix) {
    for (int i = 0; i < matrix.length / 2; i++) {
      for (int j = 0; j < matrix.length; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[matrix.length - 1 - i][j];
        matrix[matrix.length - 1 - i][j] = tmp;
      }
    }
  }

  private void rotate_diag(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix.length; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }

  public void rotate(int[][] matrix) {
    rotate_updown(matrix);
    rotate_diag(matrix);
  }
}
