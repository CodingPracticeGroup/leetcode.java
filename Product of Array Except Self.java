public class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] ret = new int[nums.length];
    ret[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      ret[i] = ret[i - 1] * nums[i - 1];
    }
    int p = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      p *= nums[i + 1];
      ret[i] *= p;
    }
    return ret;
  }
}
