public class Solution {
  public int nthUglyNumber(int n) {
    int dp[] = new int[n];
    dp[0] = 1;
    int idx2 = 0;
    int idx3 = 0;
    int idx5 = 0;
    for (int i = 1; i < n; i++) {
      int tmp2 = dp[idx2] * 2;
      while (tmp2 <= dp[i - 1]) {
        tmp2 = dp[++idx2] * 2;
      }
      int tmp3 = dp[idx3] * 3;
      while (tmp3 <= dp[i - 1]) {
        tmp3 = dp[++idx3] * 3;
      }
      int tmp5 = dp[idx5] * 5;
      while (tmp5 <= dp[i - 1]) {
        tmp5 = dp[++idx5] * 5;
      }
      if (tmp2 <= tmp3 && tmp2 <= tmp5) {
        dp[i] = tmp2;
      } else if (tmp3 <= tmp2 && tmp3 <= tmp5) {
        dp[i] = tmp3;
      } else if (tmp5 <= tmp2 && tmp5 <= tmp3) {
        dp[i] = tmp5;
      }
    }
    return dp[n - 1];
  }
}
-------------
public class Solution {
  public int nthUglyNumber(int n) {
    int dp[] = new int[n];
    dp[0] = 1;
    int l2 = 0;
    int l3 = 0;
    int l5 = 0;
    for (int i = 1; i < n; i++) {
      while (dp[l2] * 2 <= dp[i - 1]) { // lazy update
        l2++;
      }
      while (dp[l3] * 3 <= dp[i - 1]) {
        l3++;
      }
      while (dp[l5] * 5 <= dp[i - 1]) {
        l5++;
      }
      dp[i] = Math.min(Math.min(dp[l2] * 2, dp[l3] * 3), dp[l5] * 5);
    }
    return dp[n - 1];
  }
}
