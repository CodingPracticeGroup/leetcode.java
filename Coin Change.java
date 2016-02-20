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
--------------
public class Solution {
  public int coinChange(int[] coins, int amount) {
    if (coins.length == 0 || amount <= 0) {
      return 0;
    }
    long dp[] = new long[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    int min = coins[0];
    for (int i : coins) {
      if (i <= amount) {
        dp[i] = 1;
        min = Math.min(min, i);
      }
    }
    for (int i = min + 1; i <= amount; i++) {
      for (int j : coins) {
        if (i - j >= 0) {
          dp[i] = Math.min(dp[i], dp[i - j] + 1);
        }
      }
    }
    if (dp[amount] == Integer.MAX_VALUE) {
      return -1;
    } else {
      return Math.toIntExact(dp[amount]);
    }
  }
}
-----------------
public class Solution {
  public int coinChange(int[] coins, int amount) {
    if (amount == 0)
      return 0;
    if (coins.length == 0)
      return -1;

    long dp[] = new long[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int i : coins) {
      if (i <= amount)
        dp[i] = 1;
    }

    for (int i = 1; i <= amount; i++) {
      for (int j : coins) {
        if (i - j > 0)
          dp[i] = Math.min(dp[i], dp[i - j] + 1);
      }
    }

    if (dp[amount] == Integer.MAX_VALUE)
      return -1;
    return (int) dp[amount];
  }
}
