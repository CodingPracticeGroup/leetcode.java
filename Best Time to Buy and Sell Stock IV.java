public class Solution {
  private int maxProfit_max(int... t) {
    int max = t[0];
    for (int i : t) {
      max = Math.max(max, i);
    }
    return max;
  }

  private int maxProfit_(int[] prices) {
    int sum = 0;
    for (int i = 1; i < prices.length; i++) {
      sum += Math.max(0, prices[i] - prices[i - 1]);
    }
    return sum;
  }

  public int maxProfit(int k, int[] prices) {
    if (k >= prices.length)
      return maxProfit_(prices);
    int dp[][] = new int[prices.length + 1][k + 1];
    for (int i = 0; i <= prices.length; i++)
      dp[i][0] = 0;
    for (int i = 0; i <= k; i++)
      dp[0][i] = 0;

    for (int j = 1; j <= k; j++) { // j times
      int tmp_max = Integer.MIN_VALUE;
      for (int i = 1; i <= prices.length; i++) { // use [0, i) data
        // x<i-1:dp[x][j-1]+(prices[i-1]-prices[x])=prices[i-1]+(dp[x][j-1]-prices[x])=prices[i-1]+tmp_max
        dp[i][j] = maxProfit_max(dp[i][j - 1], dp[i - 1][j], prices[i - 1] + tmp_max);
        tmp_max = Math.max(tmp_max, dp[i - 1][j - 1] - prices[i - 1]);
      }
    }
    return dp[prices.length][k];
  }
}
