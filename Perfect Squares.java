public class Solution {
  public int numSquares(int n) {
    int dp[] = new int[n + 1];
    for (int i = 0; i < dp.length; i++)
      dp[i] = i;
    for (int i = 1; i * i <= n; i++)
      dp[i * i] = 1;
    for (int i = 1; i <= n; i++)
      for (int j = 1; j * j + i <= n; j++)
        dp[j * j + i] = Math.min(dp[j * j + i], dp[i] + 1);
    return dp[n];
  }
}
