public class Solution {
  public int trap(int[] height) {
    if (height.length == 0)
      return 0;

    int[] dplr = new int[height.length];
    dplr[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      dplr[i] = Math.max(dplr[i - 1], height[i]);
    }

    int[] dprl = new int[height.length];
    dprl[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      dprl[i] = Math.max(dprl[i + 1], height[i]);
    }

    int ret = 0;
    for (int i = 0; i < height.length; i++) {
      ret += Math.min(dplr[i], dprl[i]) - height[i];
    }
    return ret;
  }
}
-----------
public class Solution {
  public int trap(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int lr[] = new int[height.length];
    lr[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      lr[i] = Math.max(lr[i - 1], height[i]);
    }
    int rl[] = new int[height.length];
    rl[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      rl[i] = Math.max(rl[i + 1], height[i]);
    }
    int ret = 0;
    for (int i = 0; i < height.length; i++) {
      ret += Math.min(lr[i], rl[i]) - height[i];
    }
    return ret;
  }
}
------------------
public class Solution {
  public int trap(int[] height) {
    if (height.length == 0)
      return 0;
    int dp[] = new int[height.length];
    dp[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      dp[i] = Math.max(dp[i - 1], height[i]);
    }
    int ret = 0;
    int seen = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      seen = Math.max(seen, height[i]);
      ret += Math.min(dp[i], seen) - height[i];
    }
    return ret;
  }
}
