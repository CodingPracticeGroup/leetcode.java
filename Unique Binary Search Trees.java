public class Solution {
  public int numTrees(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, 0);
    dp[0] = 1;
    for (int i = 1; i <= n; i++) { // len
      for (int root = 0; root < i; root++) { // where root
        int left = root - 0;
        int right = i - root - 1;
        dp[i] += dp[left] * dp[right];
      }
    }
    return dp[n];
  }
}
---------------
public class Solution {
  public int numTrees(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;
    if (1 <= n)
      dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int left = 0; left < i; left++) {
        int right = i - 1 - left;
        dp[i] += dp[left] * dp[right];
      }
    }
    return dp[n];
  }
}
