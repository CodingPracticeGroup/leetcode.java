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
-------
public class Solution {
  public int numSquares(int n) {
    int dp[] = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      dp[i] = i;
    }
    for (int i = 1; i * i <= n; i++) {
      dp[i * i] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j * j < i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    return dp[n];
  }
}
-----------------
public class Solution {
  public int numSquares(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int i = 1; i * i <= n; i++) {
      dp[i * i] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j * j + i <= n; j++) {
        dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
      }
    }
    return dp[n];
  }
}
