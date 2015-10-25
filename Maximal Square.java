public class Solution {
  private int maximalSquare(int[] acc) {
    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < acc.length; i++) {
      while (!stack.isEmpty() && acc[stack.peek()] > acc[i]) {
        int h = stack.pop();
        int idx_diff = i - (stack.isEmpty() ? -1 : stack.peek()) - 1;
        int square = Math.min(idx_diff, acc[h]);
        max = Math.max(max, square * square);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int h = stack.pop();
      int idx_diff = acc.length - (stack.isEmpty() ? -1 : stack.peek()) - 1;
      int square = Math.min(idx_diff, acc[h]);
      max = Math.max(max, square * square);
    }
    return max;
  }

  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    if (m == 0)
      return 0;
    int n = matrix[0].length;
    if (n == 0)
      return 0;
    int[] acc = new int[n];
    Arrays.fill(acc, 0);
    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1')
          acc[j]++;
        else if (matrix[i][j] == '0')
          acc[j] = 0;
      }
      max = Math.max(max, maximalSquare(acc));
    }
    return max;
  }
}
