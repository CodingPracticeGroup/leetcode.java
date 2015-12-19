import java.util.Arrays;

public class Solution {
  public int maxCoins(int[] nums) {
    int[] nums_ = new int[nums.length + 2];
    nums_[0] = 1;
    nums_[nums.length + 1] = 1;
    for (int i = 0; i < nums.length; i++) {
      nums_[i + 1] = nums[i];
    }

    int dp[][] = new int[nums.length + 2][nums.length + 2]; // (,)
    for (int[] dp_ : dp) {
      Arrays.fill(dp_, -1);
    }
    for (int i = 0; i + 1 < nums.length + 2; i++) {
      dp[i][i + 1] = 0;
    }

    for (int len = 2; len < nums.length + 2; len++) {
      for (int start = 0; start + len < nums.length + 2; start++) {
        for (int last_divide = start + 1; last_divide < start + len; last_divide++) {
          dp[start][start + len] = Math.max(dp[start][start + len],
              nums_[start] * nums_[last_divide] * nums_[start + len] + dp[start][last_divide]
                  + dp[last_divide][start + len]);
        }
      }
    }

    return dp[0][nums.length + 1];
  }
}
