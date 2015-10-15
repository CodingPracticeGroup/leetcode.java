import java.util.ArrayList;
import java.util.List;

public class Solution {
  private List<Integer> spiralOrder_(int[][] matrix, int k, int m, int n) {
    List<Integer> ret = new ArrayList<>();
    if (m - k - k == 1 && n - k - k == 1) {
      ret.add(matrix[k][k]);
    } else if (m - k - k == 1 && n - k - k > 1) {
      for (int i = k; i < n - k; i++) {
        ret.add(matrix[k][i]);
      }
    } else if (m - k - k > 1 && n - k - k == 1) {
      for (int i = k; i < m - k; i++) {
        ret.add(matrix[i][k]);
      }
    } else {
      for (int i = 0 + k; i < n - k - 1; i++) {
        ret.add(matrix[0 + k][i]);
      }
      for (int i = 0 + k; i < m - k - 1; i++) {
        ret.add(matrix[i][n - k - 1]);
      }
      for (int i = n - k - 1; i > 0 + k; i--) {
        ret.add(matrix[m - k - 1][i]);
      }
      for (int i = m - k - 1; i > 0 + k; i--) {
        ret.add(matrix[i][0 + k]);
      }
    }
    return ret;
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ret = new ArrayList<>();
    int m = matrix.length;
    if (m == 0) {
      return ret;
    }
    int n = matrix[0].length;
    if (n == 0) {
      return ret;
    }
    for (int i = 0; i < Math.min(m, n) / 2 + Math.min(m, n) % 2; i++) {
      ret.addAll(spiralOrder_(matrix, i, m, n));
    }
    return ret;
  }
}
