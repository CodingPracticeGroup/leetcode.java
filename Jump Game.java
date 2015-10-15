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
