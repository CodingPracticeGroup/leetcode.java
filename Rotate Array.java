public class Solution {
  private void rotate_reverse(int[] nums, int start, int end) {
    for (int i = 0; start + i < end - 1 - i; i++) {
      int tmp = nums[start + i];
      nums[start + i] = nums[end - 1 - i];
      nums[end - 1 - i] = tmp;
    }
  }

  public void rotate(int[] nums, int k) {
    if (k == 0)
      return;
    k %= nums.length;
    rotate_reverse(nums, 0, nums.length);
    rotate_reverse(nums, 0, k);
    rotate_reverse(nums, k, nums.length);
  }
}
