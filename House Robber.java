public class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0)
      return 0;
    int dp[] = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int len = 2; len <= nums.length; len++) {
      dp[len] = Math.max(dp[len - 1], dp[len - 2] + nums[len - 1]);
    }
    return dp[nums.length];
  }
}
