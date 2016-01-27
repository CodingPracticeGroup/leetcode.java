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
---------
public class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int dp[] = new int[nums.length - 1];
    //
    for (int i = 0; i < nums.length - 1; i++) {
      dp[i] = Math.max((i - 1 >= 0 ? dp[i - 1] : 0), (i - 2 >= 0 ? dp[i - 2] : 0) + nums[i]);
    }
    int r1 = dp[nums.length - 2];
    //
    for (int i = 1; i < nums.length; i++) {
      int j = i - 1;
      dp[j] = Math.max((j - 1 >= 0 ? dp[j - 1] : 0), (j - 2 >= 0 ? dp[j - 2] : 0) + nums[i]);
    }
    int r2 = dp[nums.length - 2];
    //
    return Math.max(r1, r2);
  }
}
