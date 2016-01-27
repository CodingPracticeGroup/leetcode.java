public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> last = null;
    for (List<Integer> row : triangle) {
      int size = row.size();
      if (size >= 2) {
        row.set(0, row.get(0) + last.get(0));
        row.set(size - 1, row.get(size - 1) + last.get(size - 2));
        for (int i = 1; i <= size - 2; i++) {
          row.set(i, row.get(i) + Math.min(last.get(i - 1), last.get(i)));
        }
      }
      last = row;
    }
    int min = last.get(0);
    for (Integer i : last) {
      min = Math.min(min, i);
    }
    return min;
  }
}
-----------------
public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int rows = triangle.size();
    int dp[] = new int[rows];
    dp[0] = triangle.get(0).get(0);
    for (int i = 1; i < rows; i++) {
      int last = dp[0];
      dp[0] = dp[0] + triangle.get(i).get(0);
      for (int j = 1; j < i; j++) {
        int tmp_last = dp[j];
        dp[j] = Math.min(last, dp[j]) + triangle.get(i).get(j);
        last = tmp_last;
      }
      dp[i] = last + triangle.get(i).get(i);
    }
    return Arrays.stream(dp).min().getAsInt();
  }
}
