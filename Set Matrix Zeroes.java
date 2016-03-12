public class Solution {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    boolean firstRowZero = false;
    for (int i = 0; i < n; i++) {
      if (matrix[0][i] == 0) {
        firstRowZero = true;
        break;
      }
    }

    boolean firstColZero = false;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        firstColZero = true;
        break;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for (int i = 1; i < m; i++) {
      if (matrix[i][0] == 0) {
        Arrays.fill(matrix[i], 0);
      }
    }
    for (int i = 1; i < n; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < m; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    if (firstRowZero) {
      Arrays.fill(matrix[0], 0);
    }
    if (firstColZero) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
----------------
public class Solution {
  public void setZeroes(int[][] matrix) {
    boolean firstrowzero = false;
    boolean firstcolzero = false;

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        firstcolzero = true;
        break;
      }
    }
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        firstrowzero = true;
        break;
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        Arrays.fill(matrix[i], 0);
      }
    }
    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 0; j < matrix.length; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    if (firstrowzero) {
      Arrays.fill(matrix[0], 0);
    }
    if (firstcolzero) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
