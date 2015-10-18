public class Solution {
  public int numTrees(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, 0);
    dp[0] = 1;
    for (int i = 1; i <= n; i++) { // node count ~ value array [1,i]
      for (int root = 1; root <= i; root++) { // root value
        dp[i] += dp[root - 1] * dp[i - root];
      }
    }
    return dp[n];
  }
}
