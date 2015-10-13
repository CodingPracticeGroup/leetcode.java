public class Solution {
  private void firstMissingPositive_fix(int[] nums, int idx) {
    int fix = nums[idx];
    nums[idx] = -1;
    while (nums[fix - 1] != fix) {
      int nextFix = nums[fix - 1];
      nums[fix - 1] = fix;
      if (!(1 <= nextFix && nextFix <= nums.length)) {
        return;
      }
      fix = nextFix;
    }
  }

  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0)
      return 1;
    for (int i = 0; i < nums.length; i++) {
      if (1 <= nums[i] && nums[i] <= nums.length && nums[i] != i + 1) {
        firstMissingPositive_fix(nums, i);
      }
    }
    for (int i = 1; i <= nums.length; i++) {
      if (nums[i - 1] != i) {
        return i;
      }
    }
    return nums.length + 1;
  }
}
