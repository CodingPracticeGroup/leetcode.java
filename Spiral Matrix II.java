public class Solution {
  private int fill(int[][] ret, int idx, int len, int d) {
    if (len == 1) {
      ret[idx][idx] = d++;
      return d;
    }
    for (int i = 0; i < len - 1; i++) {
      ret[idx][idx + i] = d++;
    }
    for (int i = 0; i < len - 1; i++) {
      ret[idx + i][idx + len - 1] = d++;
    }
    for (int i = 0; i < len - 1; i++) {
      ret[idx + len - 1][idx + len - 1 - i] = d++;
    }
    for (int i = 0; i < len - 1; i++) {
      ret[idx + len - 1 - i][idx] = d++;
    }
    return d;
  }

  public int[][] generateMatrix(int n) {
    int[][] ret = new int[n][n];
    int d = 1;
    for (int i = 0; i < (n + 1) / 2; i++) {
      d = fill(ret, i, n - i * 2, d);
    }
    return ret;
  }
}
