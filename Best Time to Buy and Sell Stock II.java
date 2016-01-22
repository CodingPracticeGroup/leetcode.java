public class Solution {
  public int maxProfit_(int[] prices) {
    if (prices.length == 0)
      return 0;
    int dp[] = new int[prices.length - 1];
    for (int i = 0; i < prices.length - 1; i++) {
      dp[i] = Math.max(0, prices[i + 1] - prices[i]);
    }
    return Arrays.stream(dp).reduce(0, Integer::sum);
  }

  public int maxProfit(int[] prices) {
    int ret = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i - 1] < prices[i]) {
        ret += prices[i] - prices[i - 1]; // Calculus
      }
    }
    return ret;
  }
}
