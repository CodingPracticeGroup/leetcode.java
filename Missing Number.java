public class Solution {
  public int missingNumber(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) {
        int target = nums[i];
        nums[i] = -1;
        while (0 <= target && target < nums.length && nums[target] != target) {
          int tmp = nums[target];
          nums[target] = target;
          target = tmp;
        };
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        return i;
      }
    }
    return nums.length;
  }
}
