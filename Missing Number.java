public class Solution {
  public int missingNumber__(int[] nums) {
    int n = nums.length;
    int total = (1 + n) * n / 2;
    for (int i : nums) {
      total -= i;
    }
    return total;
  }

  private int ji(int[] nums, int idx, int k) {
    if (0 <= idx && idx <= nums.length - 1) {
      int ret = nums[idx];
      nums[idx] = k;
      return ret;
    } else {
      return -1;
    }
  }

  public int missingNumber_(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) { // nums[i] should not be here, move nums[i] to tmp
        for (int p = ji(nums, i, -1); -1 != p; p = ji(nums, p, p));
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == -1) {
        return i;
      }
    }
    return nums.length;
  }

  public int missingNumber(int[] nums) {
    return (0 + nums.length) * (nums.length + 1) / 2 - Arrays.stream(nums).sum();
  }
}
