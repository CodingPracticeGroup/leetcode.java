public class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] ret = new int[nums.length];
    ret[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      ret[i] = ret[i - 1] * nums[i];
    }
    int rl = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + 1 < nums.length)
        rl *= nums[i + 1];
      ret[i] = (i - 1 >= 0 ? ret[i - 1] : 1) * rl;
    }
    return ret;
  }
}
