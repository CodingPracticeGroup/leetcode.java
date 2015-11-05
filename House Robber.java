public class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0)
      return 0;
    int dp[] = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      dp[i] = Math.max(i - 1 >= 0 ? dp[i - 1] : 0, (i - 2 >= 0 ? dp[i - 2] : 0) + nums[i]);
    }
    return dp[nums.length - 1];
  }
}
