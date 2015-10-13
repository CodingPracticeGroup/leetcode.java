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
