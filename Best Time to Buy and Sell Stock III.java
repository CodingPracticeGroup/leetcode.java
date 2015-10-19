public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0)
      return 0;
    int dp_left[] = new int[prices.length];
    int left_max_profit = 0;
    int left_min_price = prices[0];
    for (int i = 1; i < prices.length; i++) {
      left_max_profit = Math.max(left_max_profit, prices[i] - left_min_price);
      left_min_price = Math.min(left_min_price, prices[i]);
      dp_left[i] = left_max_profit;
    }

    int dp_right[] = new int[prices.length];
    int right_max_profit = 0;
    int right_max_price = prices[prices.length - 1];
    for (int i = prices.length - 2; i >= 0; i--) {
      right_max_profit = Math.max(right_max_profit, right_max_price - prices[i]);
      right_max_price = Math.max(right_max_price, prices[i]);
      dp_right[i] = right_max_profit;
    }

    int max = 0;
    for (int i = 0; i < prices.length; i++) {
      max = Math.max(max, dp_left[i] + dp_right[i]);
    }
    return max;
  }
}
