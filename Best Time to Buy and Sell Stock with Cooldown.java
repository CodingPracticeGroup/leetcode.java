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
------------
public class Solution {
  // https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinking
  public int maxProfit(int[] prices) {
    if (prices.length < 2) { // 来不及一次完整的交易
      return 0;
    }
    int afterbuy[] = new int[prices.length + 1]; // 钱包，存量
    int aftersell[] = new int[prices.length + 1];
    int aftercooldown[] = new int[prices.length + 1];
    afterbuy[0] = -prices[0]; // 假设存量0，从当前时间点开始
    aftersell[0] = 0; // 以前的收益不算，从当前时间点开始
    aftercooldown[0] = 0;
    for (int i = 0; i < prices.length; i++) { // 状态机
      afterbuy[i + 1] = Math.max(afterbuy[i], aftercooldown[i] - prices[i]);
      aftersell[i + 1] = prices[i] + afterbuy[i];
      aftercooldown[i + 1] = Math.max(aftercooldown[i], aftersell[i]);
    }
    return Math.max(aftersell[prices.length], aftercooldown[prices.length]); // 因为cooldown可以停，不必进入buy，buy比cooldown少，所以只考虑sell和cooldown
  }
}
