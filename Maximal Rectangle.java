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
