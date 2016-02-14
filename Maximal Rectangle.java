public class Solution {
  private int maximalRectangle_row(char[] row) {
    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < row.length; i++) {
      while (!stack.isEmpty() && row[stack.peek()] > row[i]) {
        int idx = stack.pop();
        int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
        int rightBoundary = i;
        int area = (rightBoundary - leftBoundary - 1) * row[idx];
        max = Math.max(max, area);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int idx = stack.pop();
      int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
      int rightBoundary = row.length;
      int area = (rightBoundary - leftBoundary - 1) * row[idx];
      max = Math.max(max, area);
    }
    return max;
  }

  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    for (int j = 0; j < matrix[0].length; j++) {
      matrix[0][j] -= '0';
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] -= '0';
        if (matrix[i][j] > 0) {
          matrix[i][j] += matrix[i - 1][j];
        }
      }
    }
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      int row = maximalRectangle_row(matrix[i]);
      max = Math.max(max, row);
    }
    return max;
  }
}
----------------
public class Solution {
  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    if (m == 0)
      return 0;
    int n = matrix[0].length;
    if (n == 0)
      return 0;

    int height[] = new int[n];
    Arrays.fill(height, 0);
    int left[] = new int[n]; // left boundary for height[i], inclusive
    Arrays.fill(left, 0);
    int right[] = new int[n]; // right boundary for height[i], inclusive
    Arrays.fill(right, n - 1);

    int ret = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          height[j] = height[j] + 1;
        } else {
          height[j] = 0;
        }
      }

      int last = 0;
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          left[j] = Math.max(left[j], last);
        } else {
          last = j + 1;
          left[j] = 0;
        }
      }

      last = n - 1;
      for (int j = n - 1; j >= 0; j--) {
        if (matrix[i][j] == '1') {
          right[j] = Math.min(right[j], last);
        } else {
          last = j - 1;
          right[j] = n - 1;
        }
      }

      for (int j = 0; j < n; j++) {
        ret = Math.max(ret, height[j] * (right[j] - left[j] + 1));
      }
    }

    return ret;
  }
}
