public class Solution {
  public int maxProfit(int[] prices) {
    int buy_yesterday = Integer.MIN_VALUE, buy_today = Integer.MIN_VALUE;
    int sell_yesterday = 0, sell_today = 0;
    int cooldown_yesterday = 0, cooldown_today = 0;

    for (int p : prices) {
      buy_today = Math.max(buy_yesterday, cooldown_yesterday - p);
      sell_today = buy_yesterday + p;
      cooldown_today = Math.max(cooldown_yesterday, sell_yesterday);

      buy_yesterday = buy_today;
      sell_yesterday = sell_today;
      cooldown_yesterday = cooldown_today;
    }
    return Math.max(sell_yesterday, cooldown_yesterday);
  }
}
