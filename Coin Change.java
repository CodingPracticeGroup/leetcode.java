public class Solution {
  public int coinChange(int[] coins, int amount) {
    long dp[] = new long[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < amount; i++) {
      for (int j : coins) {
        if (i + j <= amount)
          dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
      }
    }
    if (dp[amount] == Integer.MAX_VALUE) {
      return -1;
    } else {
      return (int) dp[amount];
    }
  }
}
