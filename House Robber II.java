public class Solution {
  private int rob_(int[] nums, int start, int end) {
    if (start >= end)
      return 0;
    if (start + 1 == end)
      return nums[start];
    int dp[] = new int[end - start];
    dp[0] = nums[start];
    dp[1] = Math.max(dp[0], nums[start + 1]);
    for (int i = 2; start + i < end; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
    }
    return dp[end - start - 1];
  }

  public int rob(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    int rob_first = rob_(nums, 0, nums.length - 1);
    int rob_last = rob_(nums, 1, nums.length);
    return Math.max(rob_first, rob_last);
  }
}
