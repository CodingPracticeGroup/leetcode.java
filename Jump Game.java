public class Solution {
  public boolean canJump(int[] nums) {
    int far = nums[0];
    int cur = 0;
    while (far < nums.length && cur < far) {
      int next_far = far;
      for (int i = cur; i <= far; i++) {
        next_far = Math.max(next_far, i + nums[i]);
      }
      cur = far;
      far = next_far;
    }
    if (far >= nums.length - 1) {
      return true;
    }
    return false;
  }
}
----------
public class Solution {
  public boolean canJump(int[] nums) {
    int prober = 0 + nums[0];
    int anchor = 0;
    while (anchor < nums.length - 1) {
      int tmp_prober = 0;
      for (int i = anchor + 1; i < nums.length && i <= prober; i++) {
        tmp_prober = Math.max(tmp_prober, i + nums[i]);
      }
      if (tmp_prober == 0) {
        return false;
      }

      anchor = prober;
      prober = tmp_prober;
    }
    return true;
  }
}
