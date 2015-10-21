public class Solution {
  private int maxProduct_without0(int[] nums, int start, int end) {
    if (start >= end) {
      return 0;
    }
    if (start + 1 == end) {
      return nums[start];
    }
    int negativeCount = 0;
    int ret = 1;
    for (int i = start; i < end; i++) {
      ret *= nums[i];
      if (nums[i] < 0) {
        negativeCount++;
      }
    }
    if (negativeCount % 2 == 0) {
      return ret;
    } else {
      int i;
      int left = 1;
      for (i = start; i < end && nums[i] > 0; i++) {
        left *= nums[i];
      }
      if (i < end)
        left *= nums[i];
      int right = 1;
      for (i = end - 1; i >= start && nums[i] > 0; i--) {
        right *= nums[i];
      }
      if (i >= start)
        right *= nums[i];
      return Math.max(ret / left, ret / right);
    }
  }

  public int maxProduct(int[] nums) {
    int last = 0;
    while (last < nums.length && nums[last] == 0) {
      last++;
    }
    int max = Integer.MIN_VALUE;
    boolean zero = false;
    for (int i = last; i < nums.length; i++) {
      if (nums[i] == 0) {
        int seg_max = maxProduct_without0(nums, last, i);
        max = Math.max(max, seg_max);
        last = i + 1;
        zero = true;
      }
    }
    max = Math.max(max, maxProduct_without0(nums, last, nums.length));
    if (zero) {
      max = Math.max(max, 0);
    }
    return max;
  }
}
