public class Solution {
  public int lengthOfLIS(int[] nums) {
    int ret = 0;
    if (nums.length == 0)
      return ret;
    int dp[] = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      dp[i] = 1;
      ret = Math.max(ret, dp[i]);
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          ret = Math.max(ret, dp[i]);
        }
      }
    }
    return ret;
  }
}
-----------
public class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int dp[] = new int[nums.length];
    Arrays.fill(dp, 1);
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    return Arrays.stream(dp).max().getAsInt();
  }
}
-------------
http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
public class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] t = new int[nums.length];
    Arrays.fill(t, -1);
    t[0] = nums[0];
    int write = 1; // init
    for (int i = 1; i < nums.length; i++) { // same idea of 'Increasing Triplet Subsequence'
      if (nums[i] > t[write - 1]) { // extend
        t[write++] = nums[i];
      } else { // replace
        int idx = Arrays.binarySearch(t, 0, write, nums[i]);
        if (idx < 0) {
          t[-idx - 1] = nums[i];
        }
      }
    }
    return write;
  }
}
----------------------
public class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0)
      return 0;
    int dp[] = new int[nums.length];
    dp[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    return Arrays.stream(dp).max().getAsInt();
  }
}
