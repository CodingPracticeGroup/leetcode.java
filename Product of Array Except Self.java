public class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] ret = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ret[i] = nums[i] * (i - 1 >= 0 ? ret[i - 1] : 1);
    }
    int last = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      ret[i] = last * (i - 1 >= 0 ? ret[i - 1] : 1);
      last *= nums[i];
    }
    return ret;
  }
}
