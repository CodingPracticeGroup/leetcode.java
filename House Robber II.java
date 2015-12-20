public class Solution {
  int rob_internal(int[] nums, int start, int end) {
    if (end - start == 2) {
      return Math.max(nums[start], nums[start + 1]);
    } else if (end - start == 1) {
      return nums[start];
    }
    int dp[] = new int[end - start];
    dp[0] = nums[start];
    dp[1] = Math.max(nums[start], nums[start + 1]);
    for (int i = start + 2; i < end; i++) {
      dp[i - start] = Math.max(dp[i - 1 - start], dp[i - 2 - start] + nums[i]);
    }
    return dp[end - start - 1];
  }

  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    return Math.max(rob_internal(nums, 0, nums.length - 1), rob_internal(nums, 1, nums.length));
  }
}
